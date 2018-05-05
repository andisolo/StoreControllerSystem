package com.jjkj.administrator.storecontrollersystem.model;

import android.util.Base64;
import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.api.LocalService;
import com.jjkj.administrator.storecontrollersystem.bean.AfterSalesService;
import com.jjkj.administrator.storecontrollersystem.bean.AfterSalesServiceResult;
import com.jjkj.administrator.storecontrollersystem.bean.Customer;
import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.bean.Person;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.bean.Picture;
import com.jjkj.administrator.storecontrollersystem.bean.PictureUpLoadResult;
import com.jjkj.administrator.storecontrollersystem.bean.Result;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;
import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.bean.StockResult;
import com.jjkj.administrator.storecontrollersystem.db.DaoHelper;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;
import com.jjkj.administrator.storecontrollersystem.utils.RxHelper;
import com.jjkj.administrator.storecontrollersystem.view.base.BaseView;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import top.zibin.luban.Luban;

/**
 * @author Administrator
 */
public class SalesBiz implements DaoHelper, RxHelper, BaseView {
    private LocalService mLocalService = Retrofit2Utils.getServiceApiJson(LocalService.class);

    public void getOrders(Map<String, String> map, Observer<SlipResult> observer) {
        mLocalService.getOrders(map)
                .compose(bindOb())
                .subscribe(observer);
    }

    public void getUsers(Observer<PersonResult> observer) {
        mLocalService.getPersons()
                .compose(bindOb())
                .subscribe(observer);
    }

    public void getGoods(Observer<Map<String, Goods>> observer, InputStream in) {
        Observable.create((ObservableOnSubscribe<List<Goods>>) emitter -> {
            Workbook workbook = WorkbookFactory.create(in);
            List<Goods> list = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for (int i = 0; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                Goods goods = new Goods();
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    switch (j) {
                        case 0:
                            goods.setNumber(row.getCell(j).toString());
                            break;
                        case 1:
                            goods.setName(row.getCell(j).toString());
                            break;
                        case 2:
                            goods.setPrice(row.getCell(j).toString());
                            break;
                        default:
                    }
                }
                list.add(goods);
            }
            emitter.onNext(list);
            emitter.onComplete();
        })
                .map(goods -> {
                    Map<String, Goods> map = new HashMap<>(50);
                    for (Goods good : goods) {
                        map.put(good.getNumber(), good);
                    }
                    return map;
                })
                .compose(bindOb())
                .subscribe(observer);
    }

    public void saveOrders(SalesSlip slip, Observer<Result> observer) {
        Map<String, String> map = new HashMap<>(1);
        map.put("meId", slip.getSalesPerson());
        mLocalService.loadMyInfo(map)
                .flatMap((Function<PersonResult, ObservableSource<Result>>)
                        personResult -> {
                            if (personResult.getPerson().size() < 1) {
                                throw new RuntimeException("未查询到该营业员信息");
                            }
                            Person person = personResult.getPerson().get(0);
                            slip.setSalesPerson(person.getName());
                            return mLocalService.saveOrders(slip);
                        })
                .compose(bindOb())
                .subscribe(observer);
    }

    public void loadMyInfo(Map<String, String> map, Observer<PersonResult> observer) {
        mLocalService.loadMyInfo(map)
                .compose(bindOb())
                .subscribe(observer);
    }

    public void updateOrSaveMyself(Map<String, String> map, Observer<Result> observer) {
        mLocalService.updateOrSaveMyself(map)
                .compose(bindOb())
                .subscribe(observer);
    }

    public void loadVipInfo(Map<String, String> map, Observer<CustomerResult> observer) {
        mLocalService.loadVipInfo(map)
                .compose(bindOb())
                .subscribe(observer);
    }

    public void loadStock(Observer<StockResult> observer) {
        mLocalService.loadStock()
                .compose(bindOb())
                .subscribe(observer);
    }

    public void updateStock(Map<String, String> map, Observer<Result> observer) {
        Map<String, String> stringMap = new HashMap<>(1);
        stringMap.put("person", map.get("person"));
        mLocalService.loadMyInfo(stringMap)
                .flatMap((Function<PersonResult, ObservableSource<Result>>) personResult -> {
                    map.put("person", personResult.getPerson().get(0).getName());
                    Log.i("updateStock", personResult.getPerson().get(0).getName());
                    return mLocalService.updateStock(map);
                })
                .compose(bindOb())
                .subscribe(observer);
    }

    public void commitCustomer(Map<String, String> map, Observer<Result> observer) {
        mLocalService.commitCustomer(map)
                .compose(bindOb())
                .subscribe(observer);
    }

    public void loadCustomer(Observer<CustomerResult> observer) {
        mLocalService.loadCustomer()
                .compose(bindOb())
                .subscribe(observer);
    }

    public void loadCustomerService(Observer<AfterSalesServiceResult> observer) {
        mLocalService.loadAfterSalesService()
                .compose(bindOb())
                .subscribe(observer);
    }

    public void upLoadPicture(Map<String, Object> map, Observer<Result> observer) {


        Observable.create((ObservableOnSubscribe<Picture>) emitter -> {
            File file = new File((String) map.get("file"));
            File file1 = Luban.with(getMyContext()).load(file).get(file.getPath());
            Picture picture = new Picture();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            FileInputStream inputStream = new FileInputStream(file1);
            byte[] buff = new byte[1024];
            int len;
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            picture.setBase64(Base64.encodeToString(outputStream.toByteArray(),
                    Base64.NO_WRAP));
            if (file1.delete()) {
                emitter.onNext(picture);
                emitter.onComplete();
            } else {
                emitter.onError(new RuntimeException("文件删除失败"));
            }
        })
                .flatMap((Function<Picture, ObservableSource<PictureUpLoadResult>>)
                        picture -> mLocalService.upLoadPicture(picture))
                .flatMap((Function<PictureUpLoadResult, ObservableSource<Result>>)
                        pictureUpLoadResult -> {
                            AfterSalesService salesService = new AfterSalesService();
                            salesService.setName((String) map.get("name"));
                            salesService.setCustomer((Customer) map.get("customer"));
                            salesService.setPicture(pictureUpLoadResult.getPicture());
                            return mLocalService.addCustomerService(salesService);
                        })
                .compose(bindOb())
                .subscribe(observer);
    }

}
