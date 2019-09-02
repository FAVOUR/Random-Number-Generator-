package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startService;
    Button stopService;
    TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity Service id >>>>>", String.valueOf(Thread.currentThread().getId()));
        Log.d("MainActivity Service Name >>>>>", Thread.currentThread().getName());

       startService = (Button) findViewById(R.id.start_service);
       display=(TextView)findViewById(R.id.display) ;
        stopService=(Button) findViewById(R.id.stop_service);



        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent serviceIntent = new Intent(MainActivity.this,MyService.class);

                startService(serviceIntent);
            }
        });


        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceIntent = new Intent(MainActivity.this,MyService.class);


                stopService(serviceIntent);
            }
        });



    }


}
