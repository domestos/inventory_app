package com.example.inventory_app.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyController {

    private static VolleyController mInstance;

    private RequestQueue mRequestQueue;

    private static Context mCtx;

    private VolleyController(Context context){
        Log.d("log_jwt", "run VolleyController" );
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyController getInstance(Context context) {
        Log.d("log_jwt", "run VolleyController.getInstance" );
        if (mInstance == null) {
            mInstance = new VolleyController(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        Log.d("log_jwt", "run VolleyController.getRequestQueue" );
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(@NonNull final Request<T> request) {
        Log.d("log_jwt", "run VolleyController.addToRequestQueue" );
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueueWithTag(@NonNull final Request<T> request, String tag) {
        request.setTag(tag);
        getRequestQueue().add(request);
    }
}