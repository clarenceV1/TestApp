package com.example.clarence.myapp.app;


import com.example.clarence.corelibrary.ConfigManager;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ConfigHelper {
    @Inject
    ConfigManager configManger;

    @Inject
    public ConfigHelper(){

    }

    public boolean isDebug(){
        return configManger.isTest();
    }
}
