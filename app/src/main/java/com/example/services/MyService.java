package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;


/**
 * Created by Olije Favour on 8/29/2019.
 * */



public class MyService extends Service {




    private final int MAX=100;
    private final int MIN =0;
    private Boolean mIsRadomGeneratorOn=false;
    private int randomNumber;

    private  MyServiceIbinder myServiceIbinder =new MyServiceIbinder();



    @Override
    public IBinder onBind(Intent intent) {

        return myServiceIbinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("Service id >>>>>", String.valueOf(Thread.currentThread().getId()));
        Log.d("Service Name >>>>>", Thread.currentThread().getName());

       setmIsRadomGeneratorOn(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomNumberGenerator();
            }
        }).start();

//        stopSelf();
//        return super.onStartCommand(intent, flags, startId);

        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Service >>>> ", "onUnbind: ");

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("Service >>>> ", "onRebind: ");
    }

    @Override
    public void onDestroy(){
        Log.d("Service >>>> ", "onDestroy: ");
      setmIsRadomGeneratorOn(false);
        super.onDestroy();
    }

    private void startRandomNumberGenerator(){
        while (mIsRadomGeneratorOn){
            try{

                Thread.sleep(1000);

                if(mIsRadomGeneratorOn){
                    randomNumber = new Random().nextInt(MAX)+MIN;

                    Log.d("startRandomNumberGenerator >>>>>", "  Thread Name " + Thread.currentThread().getName() +"  Thread id " + Thread.currentThread().getId() + " RandomValueGenerated " + String.valueOf(randomNumber));
                }
            }catch (Throwable e){

                Log.d("Error >>>", e.getMessage());
            }
        }
    }

    private  void setmIsRadomGeneratorOn(Boolean mIsRadomGeneratorOn) {
        this.mIsRadomGeneratorOn = mIsRadomGeneratorOn;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    private class MyServiceIbinder extends Binder {
        private  MyService getMyServiceBinder(){
           return  MyService.this;
        }
    }
}
