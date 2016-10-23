package com.ladwa.aditya.offlinefirstapp.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ladwa.aditya.offlinefirstapp.data.AppDataStore;
import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;
import com.ladwa.aditya.offlinefirstapp.data.local.models.PostStorIOContentResolverDeleteResolver;
import com.ladwa.aditya.offlinefirstapp.data.local.models.PostStorIOContentResolverGetResolver;
import com.ladwa.aditya.offlinefirstapp.data.local.models.PostStorIOContentResolverPutResolver;
import com.pushtorefresh.storio.contentresolver.ContentResolverTypeMapping;
import com.pushtorefresh.storio.contentresolver.StorIOContentResolver;
import com.pushtorefresh.storio.contentresolver.impl.DefaultStorIOContentResolver;
import com.pushtorefresh.storio.contentresolver.queries.Query;

import java.util.List;

import rx.Observable;

/**
 * Created by Aditya on 23-Oct-16.
 */

public class AppLocalDataStore implements AppDataStore {
    private static AppLocalDataStore INSTANCE;
    private static StorIOContentResolver mStorIOContentResolver;
    private Context mContext;

    private AppLocalDataStore(Context context) {

        mStorIOContentResolver = DefaultStorIOContentResolver.builder()
                .contentResolver(context.getContentResolver())
                .addTypeMapping(Post.class, ContentResolverTypeMapping.<Post>builder()
                        .putResolver(new PostStorIOContentResolverPutResolver())
                        .getResolver(new PostStorIOContentResolverGetResolver())
                        .deleteResolver(new PostStorIOContentResolverDeleteResolver())
                        .build()
                ).build();
    }


    public static AppLocalDataStore getInstance(@NonNull Context context) {
        if (INSTANCE == null)
            INSTANCE = new AppLocalDataStore(context);
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<List<Post>> getPost() {
        return mStorIOContentResolver.get()
                .listOfObjects(Post.class)
                .withQuery(Query.builder().uri(DatabaseContract.Post.CONTENT_URI).build())
                .prepare()
                .asRxObservable();
    }
}
