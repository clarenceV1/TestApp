package com.example.clarence.myapp.activity;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.app.AppActivity;
import com.example.clarence.myapp.databinding.EventbusBind;
import com.example.clarence.myapp.databinding.FrescoLayout;
import com.example.clarence.myapp.event.TestEvenBus;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import de.greenrobot.event.EventBus;

/**
 * Created by clarence on 16/6/19.
 */
public class TestFrescoImageLoaderActivity extends AppActivity {
    FrescoLayout frescoLayout;
    Animatable animation;
    boolean isStartAnimation;

    @Override
    public void initVariables() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        frescoLayout = DataBindingUtil.setContentView(this, R.layout.activity_fresco);

        showImage();
        showAutoGif();
        showGif();
        showAssetsGif();
    }

    private void showGif() {
        ControllerListener controllerListener = new ControllerListener() {
            @Override
            public void onSubmit(String id, Object callerContext) {

            }

            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                animation = frescoLayout.gifView.getController().getAnimatable();
                if (animation != null) {
                    animation.start();
                    isStartAnimation = true;
                }
            }

            @Override
            public void onIntermediateImageSet(String id, Object imageInfo) {

            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {

            }

            @Override
            public void onFailure(String id, Throwable throwable) {

            }

            @Override
            public void onRelease(String id) {

            }
        };
        Uri uri = Uri.parse("asset:///test_gif.gif");
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setControllerListener(controllerListener)
                .build();
        frescoLayout.gifView.setController(draweeController);
        frescoLayout.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animation != null) {
                    if (isStartAnimation) {
                        animation.stop();
                        isStartAnimation = false;
                    } else {
                        animation.start();
                        isStartAnimation = true;
                    }
                }
            }
        });
        changeButtonText();
    }

    private void changeButtonText() {
        if (!isStartAnimation) {
            frescoLayout.button.setText("开始动画");
        } else {
            frescoLayout.button.setText("结束动画");
        }
    }

    private void showAssetsGif() {
        Uri uri = Uri.parse("asset:///test_gif.gif");
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        frescoLayout.assetsGifView.setController(draweeController);
    }

    private void showImage() {
        Uri uri = Uri.parse("http://img.club.pchome.net/kdsarticle/2013/11small/21/fd548da909d64a988da20fa0ec124ef3_1000x750.jpg");
        frescoLayout.imageView.setImageURI(uri);
    }

    private void showAutoGif() {
        Uri uri = Uri.parse("http://s1.dwstatic.com/group1/M00/73/9E/224d6773b58bce54f90e49f62cdad4da.gif");
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        frescoLayout.autoGifView.setController(draweeController);
    }
}
