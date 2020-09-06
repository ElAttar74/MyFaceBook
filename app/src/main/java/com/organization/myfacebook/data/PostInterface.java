package com.organization.myfacebook.data;

import com.organization.myfacebook.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Call<List<PostsModel>> getPosts();
}
