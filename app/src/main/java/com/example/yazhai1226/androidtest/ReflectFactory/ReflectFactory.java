package com.example.yazhai1226.androidtest.ReflectFactory;

/**
 * Created by MingRen on 2016/9/5.
 */
public abstract interface ReflectFactory {

    <T extends Product> T produce(Class<T> clz);
}
