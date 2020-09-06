package com.organization.myfacebook.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.organization.myfacebook.R;
import com.organization.myfacebook.pojo.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostsViewModel postsViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);

        postsViewModel.getPosts();
        recyclerView = findViewById(R.id.recview);

        final PostAdapter postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

        postsViewModel.postsMutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                postAdapter.setList((ArrayList<PostsModel>) postsModels);
            }
        });




    }
}