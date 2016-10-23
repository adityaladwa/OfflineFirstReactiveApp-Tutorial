package com.ladwa.aditya.offlinefirstapp.data.local.models;

import com.ladwa.aditya.offlinefirstapp.data.local.DatabaseContract;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by Aditya on 23-Oct-16.
 */

@StorIOSQLiteType(table = DatabaseContract.Post.TABLE_NAME)
@StorIOContentResolverType(uri = DatabaseContract.Post.CONTENT_URI_STRING)
public class Post {


    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_ID, key = true)
    private final Integer id;

    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_USER_ID)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_USER_ID)
    private final Integer userId;

    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_TITLE)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_TITLE)
    private final String title;

    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_BODY)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_BODY)
    private final String body;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
