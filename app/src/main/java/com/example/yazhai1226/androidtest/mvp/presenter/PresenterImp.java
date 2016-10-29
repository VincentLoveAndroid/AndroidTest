package com.example.yazhai1226.androidtest.mvp.presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.example.yazhai1226.androidtest.mvp.modle.User;
import com.example.yazhai1226.androidtest.mvp.view.IView;

/**
 * Created by MingRen on 2016/9/1.
 */
public class PresenterImp implements IPresenter {

    private IView iView;

    public PresenterImp(IView iView) {
        this.iView = iView;
    }

    @Override
    public void Login(String name, String psw) {
        new LoginTask().execute(name, psw);
    }

    @Override
    public void clearText() {
        iView.clearText();
    }

    class LoginTask extends AsyncTask<String, Void, User> {

        @Override
        protected void onPreExecute() {
            iView.login();
        }

        @Override
        protected User doInBackground(String... params) {
            String name = params[0];
            String passWord = params[1];
            try {
                Thread.sleep(2000);//模拟网络请求
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User();
            user.setName(name);
            user.setPassWord(passWord);
            return user;
        }

        @Override
        protected void onPostExecute(User user) {
            //登录结果回调
            iView.onLoginResult(user.getName());
        }
    }
}
