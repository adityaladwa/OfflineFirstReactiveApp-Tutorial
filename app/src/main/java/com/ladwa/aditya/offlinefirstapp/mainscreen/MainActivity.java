package com.ladwa.aditya.offlinefirstapp.mainscreen;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ladwa.aditya.offlinefirstapp.App;
import com.ladwa.aditya.offlinefirstapp.R;
import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;
import com.ladwa.aditya.offlinefirstapp.data.remote.AppRemoteDataStore;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View,SwipeRefreshLayout.OnRefreshListener {

    private MainScreenContract.Presenter mPresenter;

    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Inject
    AppRemoteDataStore repository;

    SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inject dependency
        App.getAppComponent().inject(this);

        listView = (ListView) findViewById(R.id.my_list);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(this);
        list = new ArrayList<>();

        new MainScreenPresenter(repository, this);
    }

    @Override
    public void showPosts(List<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            list.add(posts.get(i).getTitle());
        }
        //Create the array adapter and set it to list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "Error loading post", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(this, "Completed loading", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onRefresh() {

    }
}
