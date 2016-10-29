package com.example.yazhai1226.androidtest;

/**
 * Created by MingRen on 2016/9/7.
 */
public class MyHelper {


    public static void loadImage(final Listener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    listener.setIamge();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
