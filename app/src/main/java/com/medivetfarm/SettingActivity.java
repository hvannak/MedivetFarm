package com.medivetfarm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final Button _savesetting = findViewById(R.id.savesetting);
        final EditText _url = findViewById(R.id.url);
        final SharedPreferences sharedpreferences = getSharedPreferences("MySetting", Context.MODE_PRIVATE);
        _url.setText(sharedpreferences.getString("url",null));
        _savesetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("url", _url.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "Saved",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}
