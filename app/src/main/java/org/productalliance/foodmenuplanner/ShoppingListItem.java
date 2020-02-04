package org.productalliance.foodmenuplanner;

public class ShoppingListItem {

    private String itemQty;
    private String qtyMeasure;
    private String itemName;

    public ShoppingListItem(String itemQty, String qtyMeasure, String itemName) {
        this.itemQty = itemQty;
        this.qtyMeasure = qtyMeasure;
        this.itemName = itemName;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public String getQtyMeasure() {
        return qtyMeasure;
    }

    public void setQtyMeasure(String qtyMeasure) {
        this.qtyMeasure = qtyMeasure;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
