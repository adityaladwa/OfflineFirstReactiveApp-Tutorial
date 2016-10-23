package com.ladwa.aditya.offlinefirstapp;

import android.app.Application;

import com.ladwa.aditya.offlinefirstapp.dagger.component.AppComponent;
import com.ladwa.aditya.offlinefirstapp.dagger.component.DaggerAppComponent;
import com.ladwa.aditya.offlinefirstapp.dagger.module.AppModule;
import com.ladwa.aditya.offlinefirstapp.dagger.module.DataModule;

/**
 * Created by Aditya on 23-Oct-16.
 */

public class App extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }


    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

}
