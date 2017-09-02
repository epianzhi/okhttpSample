package com.example.okhttpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    OkHttpClient okHttpClient =new OkHttpClient() ;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listView);

    }
    public void click_before(View view){

        postData("desc");
    }

    public void click_after(View view){
        postData("asc");
    }


    private void postData(String type) {
        /**
         *  desc  指定时间之前发布的   asc指定时间之后发布的
         *  time  时间戳
         * */
        //get请求
//        getService("http://japi.juhe.cn/joke/content/list.from?key=343e0144639d222a9809f50b508c7a46&page=2&pagesize=10&sort="+type+"&time=1418745237","get",null);

        Map<String,String> map=new HashMap<>();
//        map.put("sort",type);
//        map.put("page","");
//        map.put("pagesize","10");
//        map.put("time","1018816972");
//        随机获取
        map.put("type","");
        map.put("key","343e0144639d222a9809f50b508c7a46");
        getService("http://v.juhe.cn/joke/randJoke.php?","post",map);
    }

    @Override
    protected void progressSuccess(String response) {
        super.progressSuccess(response);
        Lg.e(response.toString());
//json解析
        List<String> strings=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray array = jsonObject.optJSONArray("result");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.optJSONObject(i);
              strings.add( object.optString("content"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

//gson\解析
    /*    Gson gson=new Gson();
        Data data = gson.fromJson(response, Data.class);
        Data.Result result = data.getResult();
        List<Content> contentList = result.getData();

        for (int i = 0; i < contentList.size(); i++) {
            Content content = contentList.get(i);
            strings.add(content.getContent());
        }*/

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(arrayAdapter);
    }

}
