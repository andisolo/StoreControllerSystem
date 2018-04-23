package com.jjkj.administrator.storecontrollersystem.model;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.db.DaoHelper;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;
import com.jjkj.administrator.storecontrollersystem.entity.User;
import com.jjkj.administrator.storecontrollersystem.utils.RxHelper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

/**
 * @author Administrator
 */
public class SalesBiz implements DaoHelper, RxHelper {
    public void getOrders(Observer<List<Order>> observer) {
        Observable.create((ObservableOnSubscribe<List<Order>>) emitter -> {
            emitter.onNext(getOrderDao().loadAll());
            emitter.onComplete();
        }).compose(bindOb()).subscribe(observer);
    }

    public void addOrders(Observer<String> observer, List<OrderItem> orderItems, String name) {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            Order order = new Order();
            order.setCustomerName(name);
            order.setType(1);
            order.setUserId((long) 0);
            order.setOrderNumber(10001);
            getOrderDao().saveInTx(order);
            for (OrderItem orderItem : orderItems) {
                orderItem.setOrderId(getOrderDao().getKey(order));
            }
            getOrderItemDao().saveInTx(orderItems);
            emitter.onNext("成功保存");
            emitter.onComplete();
        }).compose(bindOb()).subscribe(observer);
    }

    public void getUsers(Observer<List<User>> observer) {
        Observable.create((ObservableOnSubscribe<List<User>>) emitter -> {
            emitter.onNext(getUserDao().loadAll());
            emitter.onComplete();
        }).compose(bindOb()).subscribe(observer);
    }

    public void addUsers(Observer<String> observer, User user) {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            getUserDao().saveInTx(user);
            emitter.onNext("添加成功");
            emitter.onComplete();
        }).compose(bindOb()).subscribe(observer);
    }

    public void deleteUsers(Observer<String> observer, User user) {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            getUserDao().deleteInTx(user);
            emitter.onNext("删除成功");
            emitter.onComplete();
        }).compose(bindOb()).subscribe(observer);
    }

    public void getGoods(Observer<List<String>> observer, InputStream in) {
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
                Log.i("SalesBiz", "" + list.size());
            }
            emitter.onNext(list);
            emitter.onComplete();
        })
                .map(goods -> {
                    List<String> list = new ArrayList<>();
                    for (Goods good : goods) {
                        list.add(good.getNumber());
                        list.add(good.getName());
                    }
                    return list;
                })
                .compose(bindOb())
                .subscribe(observer);
    }
}
