package com.example.clarence.myapp.adapter;

import android.widget.AbsListView;

import com.example.clarence.corelibrary.BaseHolder;
import com.example.clarence.corelibrary.BaseListAdapter;
import com.example.clarence.myapp.R;

import java.util.Collection;

/**
 * Created by clarence on 16/5/30.
 */
public class MvpAdapter extends BaseListAdapter {
    public MvpAdapter(AbsListView view, Collection<Integer> mDatas, int itemLayoutId) {
        super(view, mDatas, itemLayoutId);
    }

    @Override
    public void convert(BaseHolder helper, Object item, boolean isScrolling) {
        helper.setText(R.id.tvTitle, mCxt.getString((int) item));
    }
}
