package com.example.yazhai1226.androidtest;

import java.util.List;

/**
 * Created by vincent on 2016/10/15.
 * email-address:674928145@qq.com
 */

public class MyAdapter {
    private List<String> lists;

    public MyAdapter(List<String> list) {
        this.lists = list;
    }

    public void print() {
        for (String a : lists) {
            System.out.println(a);
        }
    }
}
