package com.jjkj.administrator.storecontrollersystem.utils;

import android.util.Log;

import com.jjkj.administrator.storecontrollersystem.utils.pull.PullConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator
 * @date 2018/3/26
 */

public class Retrofit2Utils {
    private static volatile OkHttpClient sOkHttpClient;
    private static volatile Retrofit sRetrofit;
    private static volatile Retrofit jRetrofit;
    private final static String BASE_URL = "http://192.168.1.101:8080/";
    private final static String BASE_URL_LOCAL = "http://192.168.1.101:8080/";
    public final static String BASE_IMG_URL = "http://192.168.1.101:8080/show_downLoadPicture?id=";

    private static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (Retrofit2Utils.class) {
                if (sOkHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
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

    private static Retrofit getRetrofitJson() {
        if (jRetrofit == null) {
            synchronized (Retrofit2Utils.class) {
                if (jRetrofit == null) {
                    Retrofit.Builder builder = new Retrofit.Builder();
                    jRetrofit = builder.client(getOkHttpClient())
                            .baseUrl(BASE_URL_LOCAL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return jRetrofit;
    }

    public static <S> S getServiceApi(Class<S> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

    public static <S> S getServiceApiJson(Class<S> serviceClass) {
        return getRetrofitJson().create(serviceClass);
    }
}

