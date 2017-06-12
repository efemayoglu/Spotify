package com.medipol.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> items = new ArrayList<>();

    public void addItem(BasketItem item) {
        items.add(item);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public boolean removeItem(Product product){
        for (BasketItem basketItem:items){
            if(basketItem.getProduct().equals(product)){
                items.remove(basketItem);
                return true;
            }
        }
        return false;
    }
    public Integer calculateBasketPrice() {
        //TODO
        Integer total_price = 0;
        for (BasketItem basketItem:items){
            total_price += basketItem.getProduct().getPrice() * basketItem.getQuantity();
        }
        return total_price;
    }
    public void updateBasketItemQuantity(BasketItem basketItem,int quanitity){
        BasketItem basketItem1 = items.stream().filter(x->x.equals(basketItem)).findFirst().get();
        basketItem1.setQuantity(quanitity);
    }
}
