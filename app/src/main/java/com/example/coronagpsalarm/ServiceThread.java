package com.example.coronagpsalarm;

import android.os.Handler;

public class ServiceThread extends Thread {
    private Handler handler;
    private boolean isRun = true;

    public ServiceThread(Handler handler){
        this.handler = handler;
    }

    public void stopForever(){
        synchronized (this) {
            this.isRun = false;
        }
    }

    public void run(){
        //반복적으로 수행할 작업을 한다.
        while(isRun){
            try{
                Thread.sleep(20000); //10초씩 쉰다.
                handler.sendEmptyMessage(0); //쓰레드에 있는 핸들러에게 메세지를 보냄
            }catch (Exception e) {}
        }
    }
}