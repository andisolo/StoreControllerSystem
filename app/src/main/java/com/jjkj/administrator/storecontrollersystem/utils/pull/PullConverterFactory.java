package com.jjkj.administrator.storecontrollersystem.utils.pull;

import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * A {@linkplain Converter.Factory converter} which uses PULL for XML.
 * All validation events are ignored.
 *
 * @author Administrator
 */


public class PullConverterFactory extends Converter.Factory {
    static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");

    public static PullConverterFactory create() {
        return new PullConverterFactory();
    }

    private PullConverterFactory() {
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new PullResponseConverter<>((Class<?>) type);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[]
            parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new PullRequestConverter<>((Class<?>) type);
    }
}
