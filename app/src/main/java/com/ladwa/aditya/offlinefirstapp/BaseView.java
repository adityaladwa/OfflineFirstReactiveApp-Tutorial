package com.ladwa.aditya.offlinefirstapp;

/**
 * A Base Presenter which is inherited by all other Presenters
 *
 */
public interface BaseView<T> {
    void setPresenter(T presenter);
}
