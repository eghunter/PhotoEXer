package com.ex.tainguyen.githuberx.data.net;

import com.ex.tainguyen.githuberx.config.Connection;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tai.nguyen on 10/6/16.
 */

public class ServiceGenerator {

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Connection.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder
                .client(getClient(getLogInterceptor()))
                .build();

        return retrofit.create(serviceClass);
    }

    protected static OkHttpClient getClient(Interceptor... interceptors) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        for (final Interceptor interceptor : interceptors) {
            httpClient.addInterceptor(interceptor);
        }

        httpClient.connectTimeout(Connection.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        return httpClient.build();
    }

    protected static Interceptor getLogInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }
}
