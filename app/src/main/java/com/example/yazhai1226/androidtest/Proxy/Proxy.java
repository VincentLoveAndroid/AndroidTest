package com.example.yazhai1226.androidtest.Proxy;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void sing() {
        source.sing();
        System.out.println("dancing");
    }
}
