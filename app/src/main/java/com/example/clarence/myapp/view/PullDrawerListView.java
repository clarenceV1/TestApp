package com.example.clarence.myapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.clarence.myapp.R;
import com.example.clarence.utillibrary.DeviceUtils;


public class PullDrawerListView extends ListView implements AbsListView.OnScrollListener {

    private LayoutInflater mInflater;

    private RelativeLayout mRefreshView;

    private int mRefreshViewHeight;
    private int mLastMotionY;
    /**
     * 屏幕高度
     */
    private int screenHeight;
    private boolean switchPull;//true=opne,false= close;


    public PullDrawerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PullDrawerListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        //获取属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PullDrawerListView, defStyle, 0);
        int headViewId = a.getResourceId(R.styleable.PullDrawerListView_headView, 0);
        if (headViewId == 0) {
            throw new IllegalArgumentException("The headViewId attribute is required and must refer "
                    + "to a valid child.");
        }
        screenHeight = DeviceUtils.getScreenHeight(context);

        //获取头部
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRefreshView = (RelativeLayout) mInflater.inflate(headViewId, this, false);

        addHeaderView(mRefreshView);
        measureView(mRefreshView);
        mRefreshViewHeight = mRefreshView.getMeasuredHeight();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (switchPull) {//open
                    setHeadHeight(screenHeight);
                } else {//关闭
                    setHeadHeight(mRefreshViewHeight);
                }
                switchPull = !switchPull;
                break;
            case MotionEvent.ACTION_DOWN:
                mLastMotionY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                setHeadHeight((int) (event.getY() - mLastMotionY) + mRefreshViewHeight);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void setHeadHeight(int headHeight) {
        ViewGroup.LayoutParams params = mRefreshView.getLayoutParams();
        params.height = headHeight;
        mRefreshView.requestLayout();
    }

    private void measureView(View child) {
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        int childHeightSpec;
        if (lpHeight > 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
        } else {
            childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}