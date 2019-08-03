package com.medivetfarm.models;

public class ReceiptLines {
    public Integer getReceiptLineId() {
        return ReceiptLineId;
    }

    public void setReceiptLineId(Integer receiptLineId) {
        ReceiptLineId = receiptLineId;
    }

    public Integer getReceiptId() {
        return ReceiptId;
    }

    public void setReceiptId(Integer receiptId) {
        ReceiptId = receiptId;
    }

    public Integer getProjectId() {
        return ProjectId;
    }

    public void setProjectId(Integer projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public Double getQty() {
        return Qty;
    }

    public void setQty(Double qty) {
        Qty = qty;
    }

    public Double getQtyInWeight() {
        return QtyInWeight;
    }

    public void setQtyInWeight(Double qtyInWeight) {
        QtyInWeight = qtyInWeight;
    }

    public Double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(Double unitCost) {
        UnitCost = unitCost;
    }

    public Double getExtCost() {
        return ExtCost;
    }

    public void setExtCost(Double extCost) {
        ExtCost = extCost;
    }

    public Integer getWarehouseId() {
        return WarehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        WarehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        WarehouseName = warehouseName;
    }

    public Integer getInventoryId() {
        return InventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        InventoryId = inventoryId;
    }

    public String getInventoryDesr() {
        return InventoryDesr;
    }

    public void setInventoryDesr(String inventoryDesr) {
        InventoryDesr = inventoryDesr;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Integer ReceiptLineId;
    public Integer ReceiptId;
    public Integer ProjectId;
    public String ProjectName;
    public Double Qty;
    public Double QtyInWeight;
    public Double UnitCost;
    public Double ExtCost;
    public Integer WarehouseId;
    public String WarehouseName;
    public Integer InventoryId;
    public String InventoryDesr;
    public String Reason;
}
