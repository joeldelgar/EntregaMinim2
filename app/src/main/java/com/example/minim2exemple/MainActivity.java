package com.example.minim2exemple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = findViewById(R.id.userNameText);
        Button info = findViewById(R.id.info_btn);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = user.getText().toString();
                Call<User> call = retrofit.create(API.class).getInfoUser(userName);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(!response.isSuccessful()){
                            Log.i("INFO", "Error "+response.code());
                            return;
                        }
                        User user = response.body();
                        Log.i("INFO", user.getId());
                        Intent intent = new Intent(MainActivity.this, FollowersActivity.class);
                        intent.putExtra("user", user.getLogin());
                        intent.putExtra("image", user.getAvatar_url());
                        intent.putExtra("repos", user.getPublic_repos());
                        intent.putExtra("following", user.getFollowing());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.i("INFO", "onFailure"+t.getMessage());
                    }
                });
            }
        });

    }
}