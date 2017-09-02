package com.example.okhttpsample;

import android.support.v7.app.AppCompatActivity;

import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/2.
 */
public class BaseActivity extends AppCompatActivity {

    class stringCallBack extends OkHttpClientManager.ResultCallback<String>{
        @Override
        public void onError(Request request, Exception e) {

        }
        @Override
        public void onResponse(String response) {
            progressSuccess(response);
        }
    }

    protected void progressSuccess(String response) {

    }

   public void getService(String url, String type, Map<String,String> map){
       OkHttpClientManager instance = OkHttpClientManager.getInstance();
       stringCallBack callback=new stringCallBack();
       //异步的get请求
       if (type.equals("get")){
           instance.getAsyn(url,callback);
       //异步的post请求
       }else if (type.equals("post")){
           Lg.e(url);
           instance.postAsyn(url,callback,map);
       }
   }
}
