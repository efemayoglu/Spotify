package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private Basket basket = new Basket();

    public Basket createBasket() {
        basket = new Basket();
        return basket;
    }

    public void printBasketDetail() {
        //TODO productName, quantity
        for (BasketItem basketItem:basket.getItems()){
            System.out.println("Product Name:"+basketItem.getProduct().getName()+ " Quantity"+basketItem.getQuantity());
        }
    }

    public BasketItem addProduct(Product product, Integer quantity){
        //TODO
        BasketItem basketItem = new BasketItem(quantity,product);
        basket.addItem(basketItem);
        return basketItem;
    }

    public boolean removeBasketItemBy(Product product){
        //TODO
        //sepetten ilgili ürünü silmeli
        boolean sonuc = basket.removeItem(product);
        return sonuc;
    }

    public void incrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar artirilmali
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                basketItem.setQuantity(basketItem.getQuantity()+quantity);
            }
        }
    }

    public void decrementQuantity(Product product, Integer quantity){
        //TODO sepetteki itemin sayisi soylenen kadar azaltilmali
        //0 ise sepetten cikartilmali
        for (BasketItem basketItem:basket.getItems()){
            if (basketItem.getProduct().equals(product)){
                if (basketItem.getQuantity()- quantity <= 0){
                    removeBasketItemBy(basketItem.getProduct());
                }else {
                    basketItem.setQuantity(basketItem.getQuantity()-quantity);
                }
                break;
            }
        }
    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getBasketPrice() {
        //TODO  sepet tutarini donmeli
        return basket.calculateBasketPrice();
    }

}
