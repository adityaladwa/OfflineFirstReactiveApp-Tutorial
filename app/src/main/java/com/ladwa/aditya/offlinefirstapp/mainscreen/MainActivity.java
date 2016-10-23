package com.ladwa.aditya.offlinefirstapp.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ladwa.aditya.offlinefirstapp.R;
import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    private MainScreenContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showPosts(List<Post> posts) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setPresenter(MainScreenContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
