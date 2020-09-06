package com.organization.myfacebook.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.organization.myfacebook.R;
import com.organization.myfacebook.pojo.PostsModel;


import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ArrayList<PostsModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.txtTitle.setText(postsList.get(position).getTitle());
        holder.txtId.setText(postsList.get(position).getUserId()+"");
        holder.txtPost.setText(postsList.get(position).getBody());

    }


    public int getItemCount() {
        return postsList.size();
    }

    public void setList(ArrayList<PostsModel> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle,txtId,txtPost;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtId = itemView.findViewById(R.id.txtId);
            txtPost = itemView.findViewById(R.id.txtPosts);
        }
    }
}
