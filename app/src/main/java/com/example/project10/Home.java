package com.example.project10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class Home extends AppCompatActivity {

    private Button openstatis;
    private Button openachive;
    private Button opentodo;
    private Button schdule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Objects.requireNonNull(getSupportActionBar()).hide();


        openstatis = (Button) findViewById(R.id.statsbtn);
        openstatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstatistics();
            }
        });

        openachive = (Button) findViewById(R.id.achievementbtn);
        openachive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openachievementbtn();
            }
        });

        opentodo = (Button) findViewById(R.id.todobtn);
        opentodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencontrolapp();
            }
        });

        schdule = (Button) findViewById(R.id.schedulebtn);
        schdule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openschdule();
            }
        });

    }

    private void openschdule() {
        Intent intent = new Intent(this, Applist.class);
        startActivity(intent);
    }

    private void opencontrolapp() {
        Intent intent = new Intent(this, Todo.class);
        startActivity(intent);
    }

    private void openachievementbtn() {
        Intent intent = new Intent(this, Achivement.class);
        startActivity(intent);
    }

    private void openstatistics() {
        Intent intent = new Intent(this, UsageOutput.class);
        startActivity(intent);
    }
}