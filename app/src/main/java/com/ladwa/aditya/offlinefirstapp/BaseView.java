package com.ladwa.aditya.offlinefirstapp;

/**
 * A Base Presenter which is inherited by all other Presenters
 * Created by Aditya on 25-Jun-16.
 */
public interface BaseView<T> {
    void setPresenter(T presenter);
}
