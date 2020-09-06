package com.organization.myfacebook.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.organization.myfacebook.data.PostsClient;
import com.organization.myfacebook.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<PostsModel>> postsMutableLiveData =
            new MutableLiveData<>();

    public void getPosts(){

        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(Call<List<PostsModel>> call, Response<List<PostsModel>> response) {
                postsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostsModel>> call, Throwable t) {

            }
        });

    }
}
