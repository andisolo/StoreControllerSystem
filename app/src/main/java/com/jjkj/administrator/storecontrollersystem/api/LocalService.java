package com.jjkj.administrator.storecontrollersystem.api;

import com.jjkj.administrator.storecontrollersystem.bean.CustomerResult;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.bean.Result;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;
import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.bean.StockResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author lenovo
 * Created on 2018-4-30.
 * @description
 */
public interface LocalService {

    /**
     * 获取所有的用户
     *
     * @return Person
     */
    @GET("user_findPerson")
    Observable<PersonResult> getPersons();

    /**
     * 获取所有的销售单
     *
     * @param map map
     * @return SalesSlip
     */
    @POST("sales_showOrders")
    @FormUrlEncoded
    Observable<SlipResult> getOrders(@FieldMap Map<String, String> map);

    /**
     * 提交销售单
     *
     * @param slip 保存的对象
     * @return SalesSlip
     */
    @POST("sales_doSales")
    Observable<Result> saveOrders(@Body SalesSlip slip);

    /**
     * 提交销售单
     *
     * @param map map
     * @return SalesSlip
     */
    @POST("user_findPerson")
    @FormUrlEncoded
    Observable<PersonResult> loadMyInfo(@FieldMap Map<String, String> map);

    /**
     * 加载自己的信息
     *
     * @param map map
     * @return SalesSlip
     */
    @POST("user_addPerson")
    @FormUrlEncoded
    Observable<Result> updateOrSaveMyself(@FieldMap Map<String, String> map);

    /**
     * 加载会员信息
     *
     * @param map map
     * @return SalesSlip
     */
    @POST("customer_findCustomer")
    @FormUrlEncoded
    Observable<CustomerResult> loadVipInfo(@FieldMap Map<String, String> map);

    /**
     * 加载库存信息
     *
     * @return SalesSlip
     */
    @GET("stock_findStock")
    Observable<StockResult> loadStock();

    /**
     * 加载库存信息
     *
     * @param map map
     * @return SalesSlip
     */
    @POST("stock_updateStock")
    @FormUrlEncoded
    Observable<Result> updateStock(@FieldMap Map<String, String> map);

    /**
     * 加载库存信息
     *
     * @param map map
     * @return SalesSlip
     */
    @POST("customer_addCustomer")
    @FormUrlEncoded
    Observable<Result> commitCustomer(@FieldMap Map<String, String> map);

    /**
     * 加载库存信息
     *
     * @return SalesSlip
     */
    @GET("customer_findCustomer")
    Observable<CustomerResult> loadCustomer();
}
