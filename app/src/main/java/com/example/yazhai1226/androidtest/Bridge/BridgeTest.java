package com.example.yazhai1226.androidtest.Bridge;

import com.example.yazhai1226.androidtest.Observer.MySubject;
import com.example.yazhai1226.androidtest.Observer.Observer1;
import com.example.yazhai1226.androidtest.Observer.Observer2;

/**
 * Created by MingRen on 2016/8/30.
 */
public class BridgeTest {
    public static void main(String args[]) {
        MyBridge myBridge = new MyBridge();
        Source1 source1 = new Source1();
        myBridge.setSource(source1);
        myBridge.sing();

        Source2 source2 = new Source2();
        myBridge.setSource(source2);
        myBridge.sing();
    }
}
