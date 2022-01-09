package com.example.minim2exemple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FollowersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        ImageView avatar = (ImageView) findViewById(R.id.imageView);
        TextView user = (TextView) findViewById(R.id.userNameText);
        TextView repos = (TextView) findViewById(R.id.repos);
        TextView following = (TextView)  findViewById(R.id.following);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewList);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(avatar);
        repos.setText("Repositories: "+ getIntent().getStringExtra("repos"));
        following.setText("Following: "+ getIntent().getStringExtra("following"));
        user.setText("user"+getIntent().getStringExtra("user"));


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        String userName = user.getText().toString();
        Call<List<User>> call = api.getFollowers(userName);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    Log.i("Followers", "Error "+response.code());
                    return;
                }
                List<User> followers = response.body();
                ListAdapter adapter = new ListAdapter(FollowersActivity.this, followers);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(FollowersActivity.this));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.i("Followers", "onFailure "+t.getMessage());
            }
        });
    }
}