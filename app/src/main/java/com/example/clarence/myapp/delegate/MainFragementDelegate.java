package com.example.clarence.myapp.delegate;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.clarence.corelibrary.delegate.FragmentDelegate;
import com.example.clarence.myapp.R;
import com.example.clarence.myapp.activity.TestMainFragement;

import butterknife.Bind;

/**
 * Created by clarence on 16/5/29.
 */
public class MainFragementDelegate extends FragmentDelegate {
    @Bind(R.id.ceshiTV)
    TextView ceshiTV;
    String fragmentTag;

    public MainFragementDelegate(String fragmentTag) {
        this.fragmentTag = fragmentTag;
    }

    @Override
    public int getRootLayoutId() {
        return R.layout.fragement_mail;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void initWidget() {
        super.initWidget();
        Fragment fragment = getFragment();
        if (fragment != null) {
            TestMainFragement mainFragement = (TestMainFragement) getFragment();
            ceshiTV.setText(mainFragement.getString());
        }
    }

    @Override
    public String getFragmentTag() {
        return fragmentTag;
    }
}
