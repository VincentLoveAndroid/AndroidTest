package com.example.yazhai1226.androidtest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Icon;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yazhai1226.androidtest.ReflectFactory.Test;
import com.example.yazhai1226.androidtest.view.MyView;
import com.example.yazhai1226.androidtest.view.WaveView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    public  List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("哈哈");
        MyAdapter adapter = new MyAdapter(list);
        adapter.print();
        System.out.println("后");
        list.add("卡卡");
        adapter.print();
    }
}