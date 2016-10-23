package com.ladwa.aditya.offlinefirstapp.data.remote;

import com.ladwa.aditya.offlinefirstapp.data.AppDataStore;
import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;

import rx.Observable;

/**
 * Created by Aditya on 23-Oct-16.
 */

public class AppRemoteDataStore implements AppDataStore {
    @Override
    public Observable<Post> getPost() {
        return null;
    }
}
