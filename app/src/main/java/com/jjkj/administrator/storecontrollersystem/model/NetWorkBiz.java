package com.jjkj.administrator.storecontrollersystem.model;

import com.jjkj.administrator.storecontrollersystem.api.StoreServiceApi;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;
import com.jjkj.administrator.storecontrollersystem.utils.RxHelper;
import com.jjkj.administrator.storecontrollersystem.utils.TimeUtils;
import com.jjkj.administrator.storecontrollersystem.utils.pull.SoapResponse;
import com.jjkj.administrator.storecontrollersystem.utils.requset.BuisnessManSelectByID;
import com.jjkj.administrator.storecontrollersystem.utils.requset.GetPosBalaceDate;
import com.jjkj.administrator.storecontrollersystem.utils.requset.WritePosBalanceDate;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;

/**
 * @author Administrator
 */
public class NetWorkBiz implements RxHelper {
    private String tag = "<GetPosBalaceDateResult>";
    private String endTag = "</GetPosBalaceDateResult>";
    private String returnTag = "<returnId>1</returnId>";
    private StoreServiceApi serviceApi = Retrofit2Utils.getServiceApi(StoreServiceApi.class);


    public void getPosBalaceDate(Observer<String> observer, String storeNumber) {
        GetPosBalaceDate request = new GetPosBalaceDate(storeNumber);
        serviceApi.getSettlementDate(request)
                .map(response -> {
                    String ret = response.getResult();
                    return storeNumber + "的最后日结日期为:" + ret.substring(ret.indexOf(tag)
                            + tag.length(), ret.indexOf(endTag));
                })
                .compose(bindOb())
                .subscribe(observer);
    }

    public void writePosBalanceDate(Observer<String> observer, String storeNumber) {
        GetPosBalaceDate request = new GetPosBalaceDate(storeNumber);
        serviceApi.getSettlementDate(request)
                .map(response -> {
                    String ret = response.getResult();
                    return ret.substring(ret.indexOf(tag) + tag.length(), ret.indexOf(endTag));
                })
                .flatMap((Function<String, ObservableSource<SoapResponse>>) s -> {
                    String timeAddOneDay = TimeUtils.getTimeAddOneDay(s);
                    WritePosBalanceDate writePosBalanceDate = new WritePosBalanceDate
                            (timeAddOneDay, storeNumber);
                    return serviceApi.writePosBalanceDate(writePosBalanceDate);
                })
                .map(response1 -> {
                    if (response1.getResult().contains(returnTag)) {
                        return "成功日结";
                    } else {
                        return "日结失败";
                    }
                })
                .compose(bindOb())
                .subscribe(observer);
    }

    public void getSalesManList(Observer<String> observer) {
        BuisnessManSelectByID request = new BuisnessManSelectByID();
        serviceApi.getBuisnessManSelectAll(request)
                .map(SoapResponse::getResult)
                .compose(bindOb())
                .subscribe(observer);
    }
}
