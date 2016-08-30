package com.example.clarence.myapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.controller.HttpController;
import com.example.clarence.myapp.response.GetIpInfoResponse;

import javax.inject.Inject;

import rx.Subscriber;

public class TestHttpActivity extends AppActivity {
    @Inject
    HttpController httpController;
    TextView testHttp;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        testHttp = (TextView) findViewById(R.id.testHttp);
        testHttp();
    }

    public void testHttp() {
        httpController.testHttp(new Subscriber<GetIpInfoResponse>() {
            @Override
            public void onCompleted() {
                testHttp.setText(testHttp.getText().toString() + "完成 ");
            }

            @Override
            public void onError(Throwable e) {
                testHttp.setText("错误 " + e.getMessage());
            }

            @Override
            public void onNext(GetIpInfoResponse getIpInfoResponse) {
                testHttp.setText(getIpInfoResponse.data.toString());
            }
        });
    }
}
