package com.example.project10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Objects;

public class Achivement extends AppCompatActivity {

    private ProgressBar probar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achivement);

        Objects.requireNonNull(getSupportActionBar()).hide();

        probar = findViewById(R.id.progressbar);
        probar.setMax(100);
    }
}