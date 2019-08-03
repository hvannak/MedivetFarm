package com.medivetfarm.models;

import java.util.Date;

public class Receipt {
    public String TranType;
    public Integer ReceiptId;
    public  String ReceiptNbr;
    public String ReceiptDate;
    public String Description;
    public Double TotalQty;
    public  Double TotalCost;
    public Boolean Release;
    public String DeletedReceiptLineIDs;

    public String getDeletedReceiptLineIDs() {
        return DeletedReceiptLineIDs;
    }

    public void setDeletedReceiptLineIDs(String deletedReceiptLineIDs) {
        DeletedReceiptLineIDs = deletedReceiptLineIDs;
    }
    public String getTranType() {
        return TranType;
    }

    public void setTranType(String tranType) {
        TranType = tranType;
    }

    public Integer getReceiptId() {
        return ReceiptId;
    }

    public void setReceiptId(Integer receiptId) {
        ReceiptId = receiptId;
    }

    public String getReceiptNbr() {
        return ReceiptNbr;
    }

    public void setReceiptNbr(String receiptNbr) {
        ReceiptNbr = receiptNbr;
    }

    public String getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        ReceiptDate = receiptDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getTotalQty() {
        return TotalQty;
    }

    public void setTotalQty(Double totalQty) {
        TotalQty = totalQty;
    }

    public Double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(Double totalCost) {
        TotalCost = totalCost;
    }

    public Boolean getRelease() {
        return Release;
    }

    public void setRelease(Boolean release) {
        Release = release;
    }

}
