package com.jjkj.administrator.storecontrollersystem.model;

import com.jjkj.administrator.storecontrollersystem.api.LocalService;
import com.jjkj.administrator.storecontrollersystem.bean.Goods;
import com.jjkj.administrator.storecontrollersystem.bean.Person;
import com.jjkj.administrator.storecontrollersystem.bean.PersonResult;
import com.jjkj.administrator.storecontrollersystem.bean.Result;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;
import com.jjkj.administrator.storecontrollersystem.bean.SlipResult;
import com.jjkj.administrator.storecontrollersystem.db.DaoHelper;
import com.jjkj.administrator.storecontrollersystem.entity.Order;
import com.jjkj.administrator.storecontrollersystem.entity.OrderItem;
import com.jjkj.administrator.storecontrollersystem.utils.Retrofit2Utils;
import com.jjkj.administrator.storecontrollersystem.utils.RxHelper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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

/**
 * @author Administrator
 */
public class SalesBiz implements DaoHelper, RxHelper {
	private LocalService mLocalService = Retrofit2Utils.getServiceApiJson(LocalService.class);

	public void getOrders(Observer<SlipResult> observer) {
		mLocalService.getOrders()
				.compose(bindOb())
				.subscribe(observer);
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
}
