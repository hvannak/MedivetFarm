package com.medivetfarm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.medivetfarm.models.VolleyCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyApplication extends Application {
    //Declare a private RequestQueue variable
    private RequestQueue requestQueue;
    private static MyApplication mInstance;
    public SharedPreferences sharedpreferences;
    public SharedPreferences  sharedpreferences_setting;
    private JSONArray jsonArrayResult;
    private JSONObject jsonObjectResult;
    public void onCreate() {
        super.onCreate();
        sharedpreferences = getSharedPreferences("Mytoken", Context.MODE_PRIVATE);
        sharedpreferences_setting = getSharedPreferences("MySetting", Context.MODE_PRIVATE);
        mInstance = this;
    }
    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
    /*
    Create a getRequestQueue() method to return the instance of
    RequestQueue.This kind of implementation ensures that
    the variable is instatiated only once and the same
    instance is used throughout the application
    */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        return requestQueue;
    }
    /*
    public method to add the Request to the the single
    instance of RequestQueue created above.Setting a tag to every
    request helps in grouping them. Tags act as identifier
    for requests and can be used while cancelling them
    */
    public void addToRequestQueue(Request request, String tag) {
        request.setTag(tag);
        getRequestQueue().add(request);
    }
    /*
    Cancel all the requests matching with the given tag
    */
    public void cancelAllRequests(String tag) {
        getRequestQueue().cancelAll(tag);
    }

    public void jsonArrayRequestResult(String api,JSONArray parameter,final VolleyCallback callback){
        final String url = sharedpreferences_setting.getString("url",null) + api;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,parameter, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Success:",response.toString());
                callback.onSuccessResponseArray(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error:",error.toString());
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                final String obj = sharedpreferences.getString("token",null);
                JsonObject jObject = new JsonParser().parse(obj).getAsJsonObject();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer " + jObject.get("token").getAsString());
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest, "getRequest");
    }

    public void jsonObjectRequestResult(String api, JSONObject parameter, final VolleyCallback callback, final boolean isLogin){
        final String url = sharedpreferences_setting.getString("url",null) + api;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, parameter, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Success:",response.toString());
                callback.onSuccessResponseObject(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error:",error.toString());
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                if(isLogin == false){
                    String obj = sharedpreferences.getString("token",null);
                    JsonObject jObject = new JsonParser().parse(obj).getAsJsonObject();
                    headers.put("Authorization", "Bearer " + jObject.get("token").getAsString());
                }
                return headers;
            }
        };
        MyApplication.getInstance().addToRequestQueue(jsonObjReq, "getRequest");
    }


}
