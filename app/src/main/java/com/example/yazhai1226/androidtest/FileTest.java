package com.example.yazhai1226.androidtest;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by mingren on 2016/1/20.
 */
public class FileTest {
    public static List<String> list = new ArrayList<>();

    public static void main(String arg[]) {
        list.add("哈哈");
        MyAdapter adapter = new MyAdapter(list);
        adapter.print();
        list.add("卡卡");
        adapter.print();
    }
}
