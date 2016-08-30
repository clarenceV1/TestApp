
package com.example.clarence.myapp.app;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

/**
 * Class used to navigate through the application.
 */
public class Navigator {

    @Inject
    public Navigator() {

    }

    /**
     * 页面跳转，解耦
     *
     * @param acticityName
     * @param intent
     */
    public void navigateTo(Context context, String acticityName, Intent intent) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(acticityName);
            if (clazz != null) {
                intent.setClass(context, clazz);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            return;
        }
    }
}
