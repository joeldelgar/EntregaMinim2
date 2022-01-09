package com.example.minim2exemple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    List<User> followers;
    Context context;

    public ListAdapter(Context context, List<User> followers){
        this.followers = followers;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_users_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyViewHolder holder, int position) {
        User user=followers.get(position);
        holder.name.setText(user.getLogin());
        Glide.with(context).load(user.getAvatar_url()).into(holder.images);
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView images;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.NameTextView);
            images=itemView.findViewById(R.id.imageView);

        }
    }
}
