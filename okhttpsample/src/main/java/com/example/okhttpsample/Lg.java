package com.example.okhttpsample;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/1.
 */

public class Lg {

    public static boolean  deBug=true;

    public static void e(String msg){
        if (deBug){
            Log.d("flag", msg);
        }
    }
}
