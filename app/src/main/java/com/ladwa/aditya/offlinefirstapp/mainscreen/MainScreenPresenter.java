package com.ladwa.aditya.offlinefirstapp.mainscreen;

/**
 * Created by Aditya on 23-Oct-16.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {


    @Override
    public void loadPost() {

    }

    @Override
    public void subscribe() {
        loadPost();
    }

    @Override
    public void unsubscribe() {
        //Unsubscribe Rx subscription
    }
}
