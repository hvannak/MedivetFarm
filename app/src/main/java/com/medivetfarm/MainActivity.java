package com.medivetfarm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.medivetfarm.models.VolleyCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button _submit = findViewById(R.id.login);
        final Button _setting = findViewById(R.id.setting);
        final EditText _username = findViewById(R.id.username);
        final EditText _password = findViewById(R.id.password);
        final SharedPreferences sharedpreferences = getSharedPreferences("Mytoken", Context.MODE_PRIVATE);
        _username.setText("vannak2010@gmail.com");
        _password.setText("123456");
        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String api = "/api/ApplicationUser/Login";
                JSONObject postparams = new JSONObject();
                try {
                    postparams.put("UserName", _username.getText());
                    postparams.put("Password", _password.getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MyApplication.getInstance().jsonObjectRequestResult(api, postparams, new VolleyCallback() {
                            @Override
                            public void onSuccessResponseObject(JSONObject result) {
                                Log.d("getObj:", result.toString());
                                if(result != null){
                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("token", result.toString());
                                    editor.commit();
                                    Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Please login again.",Toast.LENGTH_SHORT).show();
                                }
                            }

                    @Override
                    public void onSuccessResponseArray(JSONArray result) {

                    }
                },true);

            }
        });

        _setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
