package com.jjkj.administrator.storecontrollersystem;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.utils.PullHelper;
import com.jjkj.administrator.storecontrollersystem.utils.requset.GetSalesManList;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest implements PullHelper {
    @Test
    public void useAppContext() throws IOException {
        GetSalesManList getSalesManList = new GetSalesManList();
        String s = obj2xml(getSalesManList, GetSalesManList.class);
        Log.i("Test", s);
    }
}
