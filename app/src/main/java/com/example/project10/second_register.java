package com.example.project10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class second_register extends AppCompatActivity {

    //for the shifting the page of register to logging
    // to pass page from register to login
    Button registing;
    private TextView loginhere;
    //done

    TextView textView2;
    boolean[] selectedLanguage;
    ArrayList<Integer> langList = new ArrayList<>();
    String[] langArray = {"Reading", "Playing Games", "Net Surfing", "Cycling", "Listening Music", "Mobile Games","Outdoor Games","Indoor Games","Fitness","Travelling"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);


        Button registing = (Button) findViewById(R.id.registerbt);
        registing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome();
            }
        });


        loginhere = (TextView) findViewById(R.id.clicktologin);
        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });



        //Removes Title Action Bar
        Objects.requireNonNull(getSupportActionBar()).hide();


        //Set colour to the button
        Button b2 = (Button) findViewById(R.id.registerbt);
        b2.setBackgroundColor(Color.parseColor("#00FFF5"));

        //first spinner/dropdown list for status
        AutoCompleteTextView mystatus = (AutoCompleteTextView) findViewById(R.id.status1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String >(second_register.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.status));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mystatus.setAdapter(myAdapter);

        AutoCompleteTextView mywhy = (AutoCompleteTextView) findViewById(R.id.ok);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String >(second_register.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.why));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mywhy.setAdapter(myAdapter2);

        //CheckBoxes list for hobbies
        textView2 = findViewById(R.id.newf);

        // initialize selected language array
        selectedLanguage = new boolean[langArray.length];

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(second_register.this);

                // set title
                builder.setTitle("Select Hobbies");

                // set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(langArray, selectedLanguage, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // check condition
                        if (b) {
                            // when checkbox selected
                            // Add position  in lang list
                            langList.add(i);
                            // Sort array list
                            Collections.sort(langList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            langList.remove(i);
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        // use for loop
                        for (int j = 0; j < langList.size(); j++) {
                            // concat array value
                            stringBuilder.append(langArray[langList.get(j)]);
                            // check condition
                            if (j != langList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(", ");
                            }
                        }
                        // set text on textView
                        textView2.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < selectedLanguage.length; j++) {
                            // remove all selection
                            selectedLanguage[j] = false;
                            // clear language list
                            langList.clear();
                            // clear text view value
                            textView2.setText("");
                        }
                    }
                });
                // show dialog
                builder.show();
            }




        });
    }

    private void openhome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    private void openlogin() {
        Intent intent2;
        intent2 = new Intent(this, Loginwindow.class);
        startActivity(intent2);
    }

}