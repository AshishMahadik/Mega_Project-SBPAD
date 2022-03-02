package com.example.project10;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Loginwindow extends AppCompatActivity {

    private Button login;
    private TextView registerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginwindow);



        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome();
            }
        });

        //Set colour to the button
        login.setBackgroundColor(Color.parseColor("#00FFF5"));



        registerhere = (TextView) findViewById(R.id.registerhere);
        registerhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();
            }
        });

        //Removes Title Action Bar
        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    private void openregister() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void openhome() {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }
}