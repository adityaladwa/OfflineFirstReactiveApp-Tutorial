package com.ladwa.aditya.offlinefirstapp.data.local.models;

import com.ladwa.aditya.offlinefirstapp.data.local.DatabaseContract;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverColumn;
import com.pushtorefresh.storio.contentresolver.annotations.StorIOContentResolverType;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 *
 * Created by Aditya on 23-Oct-16.
 */

@StorIOSQLiteType(table = DatabaseContract.Post.TABLE_NAME)
@StorIOContentResolverType(uri = DatabaseContract.Post.CONTENT_URI_STRING)
public class Post {


    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_ID, key = true)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_ID, key = true)
    public  Integer id;

    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_USER_ID)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_USER_ID)
    public  Integer userId;

    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_TITLE)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_TITLE)
    public  String title;

    @StorIOSQLiteColumn(name = DatabaseContract.Post.COLUMN_BODY)
    @StorIOContentResolverColumn(name = DatabaseContract.Post.COLUMN_BODY)
    public  String body;

    public Post(Integer id, Integer userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
