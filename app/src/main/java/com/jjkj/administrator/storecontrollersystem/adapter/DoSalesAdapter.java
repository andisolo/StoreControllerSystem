package com.jjkj.administrator.storecontrollersystem.adapter;

import android.support.annotation.Nullable;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jjkj.administrator.storecontrollersystem.R;
import com.jjkj.administrator.storecontrollersystem.bean.SalesEntry;
import com.jjkj.administrator.storecontrollersystem.bean.SalesSlip;

import java.util.List;

/**
 * @author Administrator
 */
public class DoSalesAdapter extends BaseItemDraggableAdapter<SalesEntry, BaseViewHolder> {
	private SalesSlip mSalesSlip;

	public DoSalesAdapter(int layoutResId, @Nullable List<SalesEntry> data) {
		super(layoutResId, data);
	}

	public void setSalesSlip(SalesSlip salesSlip) {
		this.mSalesSlip = salesSlip;
	}

	@Override
	protected void convert(BaseViewHolder helper, SalesEntry item) {
		helper.setText(R.id.item_for_general_rcv_do_sales_goods, item.getCommodityName());
		helper.setText(R.id.item_for_general_rcv_do_sales_price, String.valueOf(item
				.getTotalCommodityPrice()));
		helper.setText(R.id.item_for_general_rcv_do_sales_number, String.valueOf(item
				.getCommodityQuantity()));
		EditText view = helper.getView(R.id.item_for_general_rcv_do_sales_goods);
		EditText view1 = helper.getView(R.id.item_for_general_rcv_do_sales_price);
		EditText view2 = helper.getView(R.id.item_for_general_rcv_do_sales_number);
		view.setKeyListener(null);
		view1.setKeyListener(null);
		view2.setKeyListener(null);
	}

	public SalesSlip getSalesSlip() {
		if (mSalesSlip != null) {
			mSalesSlip.setEntries(this.getData());
		}
		return mSalesSlip;
	}
}
