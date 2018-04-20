package com.jjkj.administrator.storecontrollersystem.model;

import com.jjkj.administrator.storecontrollersystem.db.DaoHelper;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;
import com.jjkj.administrator.storecontrollersystem.entity.User;
import com.jjkj.administrator.storecontrollersystem.utils.RxHelper;

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
}
