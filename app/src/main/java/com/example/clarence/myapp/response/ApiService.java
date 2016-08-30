package com.example.clarence.myapp.response;


import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


public interface ApiService {
    @GET("service/getIpInfo.php")
    Observable<GetIpInfoResponse> getIpInfo(@Query("ip") String ip);
}
