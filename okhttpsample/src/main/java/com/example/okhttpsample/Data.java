package com.example.okhttpsample;

import java.util.List;

/**
 * Created by Administrator on 2017/9/2.
 */

public class Data {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


    class Result{
        private List<Content> data;


        public List<Content> getData() {
            return data;
        }

        public void setData(List<Content> data) {
            this.data = data;
        }
    }


}
