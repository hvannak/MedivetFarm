package com.medivetfarm;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.medivetfarm.Fragments.DatePickerFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiptAddOrEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_add_or_edit);

        final Spinner _tranType =  findViewById(R.id.tranType);
        final EditText _date = findViewById(R.id.date);

        List<String> tranlist = new ArrayList<String>();
        tranlist.add("Receipt");
        tranlist.add("Issue");
        tranlist.add("Adjust");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tranlist);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _tranType.setAdapter(dataAdapter);

        _date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });
    }
}
