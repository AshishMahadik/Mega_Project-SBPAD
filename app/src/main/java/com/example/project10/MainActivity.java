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

public class MainActivity extends AppCompatActivity {
    private Button nextregster;
    private TextView loginhere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Register next button
        nextregster = (Button) findViewById(R.id.next);
        nextregster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondRegister();
            }
        });

        //Login here textview hyperlink
        loginhere = (TextView) findViewById(R.id.clicktologin);
        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });

        //Removes Title Action Bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button b2 = (Button) findViewById(R.id.next);
        b2.setBackgroundColor(Color.parseColor("#00FFF5"));

    }

    private void openlogin() {
        Intent intent = new Intent(this, Loginwindow.class);
        startActivity(intent);
    }

    public void openSecondRegister(){
        Intent intent2 = new Intent(this, second_register.class);
        startActivity(intent2);
    }


}