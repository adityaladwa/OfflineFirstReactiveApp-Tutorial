package com.ladwa.aditya.offlinefirstapp.data;

import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;

import rx.Observable;

/**
 * Created by Aditya on 23-Oct-16.
 */

public interface AppDataStore {
    Observable<Post> getPost();
}
