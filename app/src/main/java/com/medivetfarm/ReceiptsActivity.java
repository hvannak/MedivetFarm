package com.medivetfarm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.medivetfarm.Adapters.ReceiptAdapter;
import com.medivetfarm.models.Receipt;
import com.medivetfarm.models.VolleyCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiptsActivity extends AppCompatActivity {

    public Receipt _receipt;
    public int _oldPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);


        final ListView _listreceipt = findViewById(R.id.listreceipt);
        final Button _btnAdd = findViewById(R.id.addreceipt);
        final Button _btnEdit = findViewById(R.id.editreceipt);
        final Button _btnDelete = findViewById(R.id.deletereceipt);
        final String api = "/api/Receipts";
        MyApplication.getInstance().jsonArrayRequestResult(api, null, new VolleyCallback() {
            @Override
            public void onSuccessResponseObject(JSONObject result) {

            }

            @Override
            public void onSuccessResponseArray(JSONArray result) {
                ArrayList<Receipt> arrayOfReceipt = new ArrayList<Receipt>();
                for(int n = 0; n < result.length(); n++)
                {
                    try {
                        JSONObject objarray = result.getJSONObject(n);
                        Receipt receipt = new Receipt();
                        receipt.setReceiptId(objarray.getInt("ReceiptId"));
                        receipt.setReceiptNbr(objarray.getString("ReceiptNbr"));
                        receipt.setDescription(objarray.getString("Description"));
                        receipt.setTotalCost((objarray.getDouble("TotalCost")));
                        receipt.setTotalQty(objarray.getDouble("TotalQty"));
                        receipt.setTranType(objarray.getString("TranType"));
                        String dateStr = objarray.getString("ReceiptDate");
                        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date date = simpleDateFormat.parse(dateStr);
                            receipt.setReceiptDate(simpleDateFormat.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        arrayOfReceipt.add(receipt);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // do some stuff....
                }

                ReceiptAdapter adapter = new ReceiptAdapter(getApplicationContext(), arrayOfReceipt);
                _listreceipt.setAdapter(adapter);

                _listreceipt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        _btnEdit.setEnabled(true);
                        _btnDelete.setEnabled(true);
                        if(_oldPosition != -1){
                            _listreceipt.getChildAt(_oldPosition).setBackgroundColor(Color.parseColor("#756d5e"));
                        }
                        _receipt = (Receipt)_listreceipt.getItemAtPosition(position);
                        _listreceipt.getChildAt(position).setBackgroundColor(Color.BLUE);
                        _oldPosition = position;
                        return false;
                    }
                });
            }
        });




        //Add
        _btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceiptsActivity.this,ReceiptAddOrEditActivity.class);
                startActivity(intent);
            }
        });

        _btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit:",_receipt.getReceiptId().toString());
                Intent intent = new Intent(ReceiptsActivity.this,ReceiptAddOrEditActivity.class);
                startActivity(intent);
            }
        });

        _btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Delete:",_receipt.getReceiptId().toString());
            }
        });
    }
}
