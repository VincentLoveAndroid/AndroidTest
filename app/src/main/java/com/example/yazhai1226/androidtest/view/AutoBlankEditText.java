package com.example.yazhai1226.androidtest.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mingren on 2016/1/8.
 */
public class AutoBlankEditText extends EditText {
    private static int textLength;
    private boolean isDelete;
    private int beforeTextLength;

    public AutoBlankEditText(Context context) {
        super(context);
        init();
    }

    public AutoBlankEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoBlankEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();

    }

    private void init() {
        this.addTextChangedListener(new TextWatcher() {
            @Override
            //是在Text改变之前被调用，它的意思就是说在原有的文本s中，从start开始的count个字符将会被一个新的长度为after的文本替换，注意这里是将被替换，还没有被替换。
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                beforeTextLength = s.length();//记录文本改变前的文本长度
            }

            //说在原有的文本s中，从start开始的count个字符替换长度为before的旧文本，注意这里没有将要之类的字眼，也就是说一句执行了替换动作。
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textLength = s.length();
                //setSelection(textLength);//设置光标的位置
                //根据文本长度的变化，判断是在增加还是删除文本
                if (beforeTextLength < textLength) {
                    isDelete = false;
                } else {
                    isDelete = true;
                }
                if (!isDelete) {
                    if (textLength % 5 == 4) {
                        getText().insert(getSelectionStart(), " ");//每到第四个输入插入一个空格
                    }
                } else {
                    if (textLength % 5 == 4) {
                        getText().delete(getSelectionStart() - 1, getSelectionStart());//删除光标前一个字符
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
