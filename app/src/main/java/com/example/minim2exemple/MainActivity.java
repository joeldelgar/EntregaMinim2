package com.example.minim2exemple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView usernom = findViewById(R.id.userNameText);
        Button info = findViewById(R.id.info_btn);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = usernom.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("userName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("User", userName);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), FollowersActivity.class);
                startActivity(intent);
            }
        });

    }
}