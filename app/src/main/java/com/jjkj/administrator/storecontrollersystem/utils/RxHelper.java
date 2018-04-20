package com.jjkj.administrator.storecontrollersystem.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Administrator
 * @date 2018/3/24
 */
@SuppressWarnings("unused")
public interface RxHelper {


    /**
     * 创建绑定线程的OB变形器
     *
     * @param <T> Ob的泛型
     * @return 返回OB变形器
     */
    default <T> ObservableTransformer<T, T> bindOb() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread());
    }

    /**
     * 创建绑定线程的且带有重试功能的OB变形器
     *
     * @param times 重新执行的次数
     * @param <T>   Ob的泛型
     * @return 返回OB变形器
     */
    default <T> ObservableTransformer<T, T> bindObWithRetry(long times) {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread()).retry(times);
    }

    /**
     * 创建绑定线程的且带有重试功能的OB变形器
     * retryWhen变形器默认执行3次,延时3000毫秒
     *
     * @param <T> Ob的泛型
     * @return 返回OB变形器
     */
    default <T> ObservableTransformer<T, T> bindObWithRetryWhen() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread()).retryWhen(new RetryWithDelay(3, 3000));
    }

    /**
     * 创建绑定线程的且带有RetryWhen功能的OB变形器
     *
     * @param maxRetries       重试的最大次数
     * @param retryDelayMillis 重试的执行延迟
     * @param <T>              Ob的泛型
     * @return 返回OB变形器
     */
    default <T> ObservableTransformer<T, T> bindObWithRetryWhen(int maxRetries, int
            retryDelayMillis) {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread()).retryWhen(new RetryWithDelay(maxRetries, retryDelayMillis));
    }


    class RetryWithDelay implements Function<Observable<? extends Throwable>,
            ObservableSource<?>> {
        private final int maxRetries;
        private final int retryDelayMillis;
        private int retryCount;

        RetryWithDelay(int maxRetries, int retryDelayMillis) {
            this.maxRetries = maxRetries;
            this.retryDelayMillis = retryDelayMillis;
        }

        @Override
        public ObservableSource<?> apply(Observable<? extends Throwable> observable) {
            return observable.flatMap((Function<Throwable, ObservableSource<?>>) throwable -> {
                if (++retryCount < maxRetries) {
                    return Observable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                }
                return Observable.error(throwable);
            });
        }
    }
}
