package com.example.clarence.myapp.activity;

import com.example.clarence.corelibrary.delegate.IDelegate;
import com.example.clarence.corelibrary.presenter.BaseFragmentPresenter;
import com.example.clarence.myapp.delegate.MainFragementDelegate;

/**
 * Created by clarence on 16/5/29.
 */
public class TestMainFragement extends BaseFragmentPresenter {
    MainFragementDelegate mainFragementDelegate;

    @Override
    public IDelegate getViewDelegate() {
        if (mainFragementDelegate == null) {
            mainFragementDelegate = new MainFragementDelegate(getFragmentTag());
        }
        return mainFragementDelegate;
    }

    @Override
    public String getFragmentTag() {
        return TestMainFragement.class.getName();
    }

    public String getString() {
        return "this is fragement view";
    }
}
