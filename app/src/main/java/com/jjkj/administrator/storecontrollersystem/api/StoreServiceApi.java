package com.jjkj.administrator.storecontrollersystem.api;


import com.jjkj.administrator.storecontrollersystem.utils.pull.SoapResponse;
import com.jjkj.administrator.storecontrollersystem.utils.requset.BuisnessManSelectByID;
import com.jjkj.administrator.storecontrollersystem.utils.requset.GetPosBalaceDate;
import com.jjkj.administrator.storecontrollersystem.utils.requset.WritePosBalanceDate;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @author Administrator
 */
public interface StoreServiceApi {


    /**
     * 获取日结的最后时间
     * SOAPAction: SOAPAction: http://www.myregent.cn/GetPosBalaceDate请求的Action，类似于方法名
     *
     * @param getPosBalaceDate 查询用请求实体
     * @return 返回实体
     */
    @Headers({"Content-Type: text/xml; charset=utf-8",
            "SOAPAction: http://www.myregent.cn/GetPosBalaceDate"})
    @POST("RegentGeneric.asmx?")
    Observable<SoapResponse> getSettlementDate(@Body GetPosBalaceDate getPosBalaceDate);
    /**
     * 发送店铺日结申请
     * SOAPAction: SOAPAction: http://www.myregent.cn/GetPosBalaceDate请求的Action，类似于方法名
     *
     * @param writePosBalanceDate 查询用请求实体
     * @return 返回实体
     */
    @Headers({"Content-Type: text/xml; charset=utf-8",
            "SOAPAction: http://www.myregent.cn/WritePosBalanceDate2"})
    @POST("RegentGeneric.asmx?")
    Observable<SoapResponse> writePosBalanceDate(@Body WritePosBalanceDate writePosBalanceDate);

    /**
     * 获取所有的营业员列表
     * SOAPAction: urn:queryObjectOutServer 请求的Action，类似于方法名
     *
     * @param buisnessManSelectByID 查询用请求实体
     * @return 返回实体
     */
    @Headers({"Content-Type: text/xml; charset=utf-8",
            "SOAPAction: http://tempuri.org/BuisnessManSelectByID"})
    @POST("RegentWarehouse.asmx")
    Observable<SoapResponse> getBuisnessManSelectAll(@Body BuisnessManSelectByID
                                                             buisnessManSelectByID);
}
