package com.ladwa.aditya.offlinefirstapp.mainscreen;

import com.ladwa.aditya.offlinefirstapp.BasePresenter;
import com.ladwa.aditya.offlinefirstapp.BaseView;
import com.ladwa.aditya.offlinefirstapp.data.local.models.Post;

import java.util.List;

/**
 * Created by Aditya on 23-Oct-16.
 */

public class MainScreenContract {

    interface View extends BaseView<Presenter> {

        void showPosts(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter extends BasePresenter {
        void loadPost();
        void loadPostFromRemoteDatatore();
    }
}
