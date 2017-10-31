package com.example.minu.movieapp.activity;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD})
/**
 * Created by minu on 10/30/2017.
 */
public @interface BindView {
    @IdRes
    int value();
}
