package com.jjkj.administrator.storecontrollersystem.utils.pull;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author Administrator
 */
public class PullResponseConverter<T> implements Converter<ResponseBody, T> {
    private final Class<T> type;

    PullResponseConverter(Class<T> type) {
        this.type = type;
    }


    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        T t;
        try {
            t = type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        String ret = value.string();
        String string = ret.substring(ret.indexOf("<soap:Body>") + "<soap:Body>".length
                (), ret.indexOf("</soap:Body>"));
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if ("result".equals(field.getName())) {
                    field.set(t, string);
                    Log.i("PullResponseConverter", string);
                }
            } catch (IllegalAccessException e) {
                throw new IOException(e);
            }
        }
        return t;
    }
}
