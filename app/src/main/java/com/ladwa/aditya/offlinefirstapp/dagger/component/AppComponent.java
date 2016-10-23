package com.ladwa.aditya.offlinefirstapp.dagger.component;

import com.ladwa.aditya.offlinefirstapp.dagger.module.AppModule;
import com.ladwa.aditya.offlinefirstapp.dagger.module.DataModule;
import com.ladwa.aditya.offlinefirstapp.data.remote.AppRemoteDataStore;
import com.ladwa.aditya.offlinefirstapp.mainscreen.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aditya on 23-Oct-16.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(AppRemoteDataStore appRemoteDataStore);
}
