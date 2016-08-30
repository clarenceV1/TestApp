package com.example.clarence.myapp.dagger.components;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by clarence on 16/4/4.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeActivity {
}
