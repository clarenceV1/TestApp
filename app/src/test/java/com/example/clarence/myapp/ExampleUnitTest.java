package com.example.clarence.myapp;

import com.example.clarence.myapp.activity.TestHttpActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 21)
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        TestHttpActivity mainActivity = Robolectric.setupActivity(TestHttpActivity.class);
        mainActivity.testHttp();
    }
}