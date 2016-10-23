package com.ladwa.aditya.offlinefirstapp.data.remote;

import com.ladwa.aditya.offlinefirstapp.App;
import com.ladwa.aditya.offlinefirstapp.data.AppDataStore;
import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Aditya on 23-Oct-16.
 */

public class AppRemoteDataStore implements AppDataStore {

    @Inject
    Retrofit retrofit;

    private static AppRemoteDataStore INSTANCE = null;

    private AppRemoteDataStore() {
        App.getAppComponent().inject(this);
    }

    public static AppRemoteDataStore getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppRemoteDataStore();
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<List<Post>> getPost() {
        return retrofit.create(PostService.class).getPostList();
    }


    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}
