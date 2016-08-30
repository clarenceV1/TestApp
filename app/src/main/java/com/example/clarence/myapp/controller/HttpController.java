package com.example.clarence.myapp.controller;

import com.example.clarence.myapp.manager.HttpManager;
import com.example.clarence.myapp.response.ApiService;
import com.example.clarence.myapp.response.ApiUrl;
import com.example.clarence.myapp.response.GetIpInfoResponse;

import java.io.IOException;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by clarence on 16/4/4.
 */
public class HttpController extends AppController {
    @Inject
    HttpManager httpManager;

    @Inject
    public HttpController() {

    }

    public void testHttp(Subscriber subscriber) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrl.searchIpAddressUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            ApiService apiService = retrofit.create(ApiService.class);
            apiService.getIpInfo("63.223.108.42")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
