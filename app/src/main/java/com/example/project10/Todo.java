package com.example.project10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class Todo extends AppCompatActivity {

    private Button addapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);


        //Removes Title Action Bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        addapp = (Button) findViewById(R.id.addapp);
        addapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddapp();
            }
        });
    }

    private void openaddapp() {
        Intent intent = new Intent(this, Applist.class);
        startActivity(intent);
    }
}