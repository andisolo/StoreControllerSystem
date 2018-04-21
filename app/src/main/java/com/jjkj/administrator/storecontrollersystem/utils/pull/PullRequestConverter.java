package com.jjkj.administrator.storecontrollersystem.utils.pull;

import android.support.annotation.NonNull;

import com.jjkj.administrator.storecontrollersystem.utils.PullHelper;

import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * @author Administrator
 */
public class PullRequestConverter<T> implements Converter<T, RequestBody>, PullHelper {
    private final Class<T> type;

    PullRequestConverter(Class<T> type) {
        this.type = type;
    }

    @Override
    public RequestBody convert(@NonNull T value) throws IOException {
        return RequestBody.create(PullConverterFactory.XML, obj2xml(value, type));
    }
}
