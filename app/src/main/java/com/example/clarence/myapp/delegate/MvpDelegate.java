package com.example.clarence.myapp.delegate;

import android.widget.TextView;

import com.example.clarence.corelibrary.delegate.ActivityDelegate;
import com.example.clarence.myapp.R;
import com.example.clarence.myapp.activity.TestMvpActivity;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by clarence on 16/5/29.
 */
public class MvpDelegate extends ActivityDelegate {
    @Bind(R.id.testMvp)
    TextView testMvp;
    @Inject
    public MvpDelegate() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TestMvpActivity activity = getActivity();
        testMvp.setText(activity.getResult());
    }

}
