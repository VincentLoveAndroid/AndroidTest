package com.example.yazhai1226.androidtest.Adapater;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public class Adapter extends Source implements Targetable {
    //适配器将某个类的接口转化成客户端期望的表示，sing方法为Source所实现
    @Override
    public void dance() {
        System.out.println("dancing");
    }
}
