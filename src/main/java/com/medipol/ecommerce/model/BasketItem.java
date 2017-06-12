package com.medipol.ecommerce.model;

public class BasketItem {

    private int quantity;
    private Product product;

    public BasketItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer price() {
        //TODO
        return quantity * product.getPrice();
    }

}
