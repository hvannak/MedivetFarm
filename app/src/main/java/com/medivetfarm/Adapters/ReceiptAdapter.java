package com.medivetfarm.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.medivetfarm.R;
import com.medivetfarm.models.Receipt;

import java.util.ArrayList;

public class ReceiptAdapter extends ArrayAdapter<Receipt> {

    public ReceiptAdapter(Context context, ArrayList<Receipt> receipts) {
        super(context, 0, receipts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Receipt receipt = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_receipt, parent, false);
        }
        // Lookup view for data population
        TextView _receiptNbr = (TextView) convertView.findViewById(R.id.receiptNbr);
        TextView _totalQty = (TextView) convertView.findViewById(R.id.totalQty);
        TextView _totalCost = (TextView) convertView.findViewById(R.id.totalCost);
        TextView _description = (TextView) convertView.findViewById(R.id.description);
        TextView _type = (TextView)convertView.findViewById(R.id.type);
        TextView _date = (TextView)convertView.findViewById(R.id.date);

        // Populate the data into the template view using the data object
        _receiptNbr.setText(receipt.getReceiptNbr());
        _description.setText(receipt.getDescription());
        _totalQty.setText(receipt.getTotalQty().toString());
        _totalCost.setText(receipt.getTotalCost().toString());
        _type.setText(receipt.getTranType());
        _date.setText(receipt.getReceiptDate().toString());


        // Return the completed view to render on screen
        return convertView;

    }
}
