package com.example.clarence.myapp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.clarence.utillibrary.DeviceUtils;

public class ScrollBehavior extends CoordinatorLayout.Behavior {
    Context context;
    int dp100;

    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        dp100 = DeviceUtils.dip2px(context, 100);
    }


    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        NestedScrollView nestedScrollView = (NestedScrollView) target;
        int scrollHeight = nestedScrollView.getScrollY();
        int newHeight = dp100 + -scrollHeight;
        refreshChildView(newHeight, child);
     //   refreshTargetView(scrollHeight, target);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        NestedScrollView nestedScrollView = (NestedScrollView) target;
        int scrollHeight = nestedScrollView.getScrollY();
        int newHeight = dp100 + -scrollHeight;
        refreshChildView(newHeight, child);
     //   refreshTargetView(scrollHeight, target);
        return true;
    }

    private void refreshChildView(int newHeight, View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        params.height = newHeight;
        child.requestLayout();
    }

    private void refreshTargetView(int scrollHeight, View target) {
        target.setPadding(target.getLeft(), target.getTop() - scrollHeight, target.getRight(), target.getBottom());
    }
}
