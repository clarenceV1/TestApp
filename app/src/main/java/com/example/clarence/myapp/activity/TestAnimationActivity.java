package com.example.clarence.myapp.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.databinding.AnimationLayout;
import com.example.clarence.utillibrary.ToastUtils;

public class TestAnimationActivity extends Activity {
    AnimationLayout animationLayout;
    int repeat;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationLayout = DataBindingUtil.setContentView(this, R.layout.activity_animation);

        animationLayout.image.startAnimation(getAnimation());
        ToastUtils.showToast(this, "test");
    }

    public Animation getAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.5f, 1f, 1.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(4000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                repeat++;
                animationLayout.image.setText(repeat + "");
            }
        });

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1);
        alphaAnimation.setDuration(4000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }
}
