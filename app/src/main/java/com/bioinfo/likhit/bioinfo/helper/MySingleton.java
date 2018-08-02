/*
Created By: Likhit C U
Date:02-08-2018
Singleton class
 */

package com.bioinfo.likhit.bioinfo.helper;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton extends Application {
    public static final String TAG=MySingleton.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private static MySingleton mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static synchronized MySingleton getInstance(){return mInstance;}

    public RequestQueue getRequestQueue(){
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue (Request<T> req, String tag){
        //set the default tag if the Tag is empty
        req.setTag(TextUtils.isEmpty(tag)?TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue (Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if (mRequestQueue != null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
