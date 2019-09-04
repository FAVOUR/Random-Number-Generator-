package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startService;
    Button stopService;
    Button bindService;
    Button unbindService;
    Button randomNumber;

    TextView display;

    MyService myService;
    private Boolean isServiceBound;
    ServiceConnection serviceConnection;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity Service id >>>>>", String.valueOf(Thread.currentThread().getId()));
        Log.d("MainActivity Service Name >>>>>", Thread.currentThread().getName());

       startService = (Button) findViewById(R.id.start_service);
       display=(TextView)findViewById(R.id.display) ;
        stopService=(Button) findViewById(R.id.stop_service);
        bindService = (Button) findViewById(R.id.bind);
        unbindService=(Button) findViewById(R.id.unbind) ;
        randomNumber=(Button) findViewById(R.id.getRandomNumber);


        startService.setOnClickListener(this);
         stopService.setOnClickListener(this);
         bindService.setOnClickListener(this);
         unbindService.setOnClickListener(this);
         randomNumber.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        Intent serviceIntent = new Intent(MainActivity.this,MyService.class);

        switch (view.getId()){
            case R.id.start_service:{
                startService(serviceIntent);
            }
            break ;
            case R.id.stop_service:{
                stopService(serviceIntent);

            }
            break ;
            case R.id.bind:{

            }
            break ;
            case R.id.unbind:{

            }
            break ;
            case R.id.getRandomNumber:{

            }
            break ;

            default:
                Toast.makeText(this,"You have selected Nothing ",Toast.LENGTH_SHORT).show();

        }
    }
}
