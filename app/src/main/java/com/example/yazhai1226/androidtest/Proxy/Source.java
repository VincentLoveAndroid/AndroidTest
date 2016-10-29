package com.example.yazhai1226.androidtest.Proxy;

/**
 * Created by MingRen on 2016/8/29.
 */
public class Source implements Sourceable{
    @Override
    public void sing() {
        System.out.println("Sourceable-sing");
    }
}
