package com.example.updatecontact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import static android.R.attr.id;


public class FirstActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

     @Override
            public void onClick(View view){

             Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

         startActivity(intent);



                }

        });
    }


    }


