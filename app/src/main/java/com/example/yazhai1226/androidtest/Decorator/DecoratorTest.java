package com.example.yazhai1226.androidtest.Decorator;

import com.example.yazhai1226.androidtest.Bridge.MyBridge;
import com.example.yazhai1226.androidtest.Bridge.Source1;
import com.example.yazhai1226.androidtest.Bridge.Source2;

/**
 * Created by MingRen on 2016/8/30.
 */
public class DecoratorTest {
    public static void main(String args[]) {
        Source source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.sing();
    }
}
