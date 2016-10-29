package com.example.yazhai1226.androidtest.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import com.example.yazhai1226.androidtest.R;

import java.util.TimerTask;

/**
 * Created by MingRen on 2016/8/10.
 */
public class LeakActivity extends Activity {

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread = new LeakThread();
        thread.start();
    }

    static class LeakThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("加载数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
