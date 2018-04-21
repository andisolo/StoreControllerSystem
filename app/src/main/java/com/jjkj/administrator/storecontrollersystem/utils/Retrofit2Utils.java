package com.jjkj.administrator.storecontrollersystem.utils;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.utils.pull.PullConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author Administrator
 * @date 2018/3/26
 */

public class Retrofit2Utils {
    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;
    private final static String BASE_URL = "192.168.1.1/";

    private static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (Retrofit2Utils.class) {
                if (sOkHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.interceptors().add(chain -> {
                        Request original = chain.request();
                        // 对于SOAP 1.1，
                        // 如果是soap1.2 应是Content-Type: application/soap+xml; charset=utf-8
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Content-Type", "text/xml; charset=utf-8")
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    });
                    HttpLoggingInterceptor okHttp = new HttpLoggingInterceptor(message -> Log.i
                            ("OkHttp", message));
                    okHttp.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.interceptors().add(okHttp);
                    sOkHttpClient = builder.connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build();
                }
            }
        }

        return sOkHttpClient;
    }

    private static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            synchronized (Retrofit2Utils.class) {
                if (sRetrofit == null) {
                    Retrofit.Builder builder = new Retrofit.Builder();
                    sRetrofit = builder.client(getOkHttpClient())
                            .baseUrl(BASE_URL)
                            //使用PULL技术解析XML
                            .addConverterFactory(PullConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return sRetrofit;
    }

    public static <S> S getServiceApi(Class<S> serviceClass) {
        return getRetrofit().create(serviceClass);
    }
}

