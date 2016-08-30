package com.example.clarence.myapp;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.clarence.myapp.activity.TestHttpActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by clarence on 16/8/29.
 */
@RunWith(AndroidJUnit4.class)
public  class AutoTest {

    // Rule 这句代表了运行的是哪个Activity
    @Rule
    public ActivityTestRule<TestHttpActivity> mActivityRule = new ActivityTestRule<>(TestHttpActivity.class);

    @Test
    public void ensureTextChangesWork() {
        onView(ViewMatchers.withId(R.id.testHttp)).perform(click());
    }
}
