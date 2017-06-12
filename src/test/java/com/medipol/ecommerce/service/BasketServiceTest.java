package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;


import static org.junit.Assert.*;
public class BasketServiceTest {

    BasketService basketService = new BasketService();
    @Test
    public void shouldCreateBasket() throws Exception {
        //TODO
        basketService.createBasket();
        assertFalse(basketService.getBasket() == null);
    }

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {
        //TODO
        Product product = new Product(1,"iphone7",100);
        int quantity = 1;
        BasketItem basketItem = basketService.addProduct(product,quantity);
        assertTrue( basketItem.getProduct().getPrice() * basketItem.getQuantity() == 100);
    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {
        //TODO
        Product product = new Product(1,"iphone7",100);
        int quantity = 2;
        BasketItem basketItem = basketService.addProduct(product,quantity);
        assertThat( basketItem.getProduct().getPrice() * basketItem.getQuantity() ,Matchers.equalTo(200));
    }

    @Test
    public void shouldAddMultipleProduct() throws Exception {
        //TODO
        Product product1 = new Product(1,"Dimes Meyve Suyu",4);
        Product product2 = new Product(2,"Icim Süt",3);
        basketService.addProduct(product1,1);
        basketService.addProduct(product2,1);
        assertThat(basketService.getBasket().getItems().size(),Matchers.equalTo(2));
    }

    @Test
    public void shouldRemoveProduct() throws Exception {
        //TODO
        //sepetten urunu sildi mi
        Product product = new Product(1,"Muz",10);
        basketService.addProduct(product,1);
        //assertTrue(basketService.getBasket().getItems().size() == 1);
        basketService.removeBasketItemBy(product);
        assertTrue(basketService.getBasket().getItems().size() == 0);
    }

    @Test
    public void shouldIncrementBasketItemQuantity() throws Exception {
        //TODO
        Product product = new Product(1,"Muz",10);
        basketService.addProduct(product,5);
        basketService.incrementQuantity(product,5);
        assertThat(basketService.getBasket().getItems().get(0).price(),Matchers.equalTo(100));

    }
    @Test
    public void shouldDecrementBasketItemQuantity() throws Exception {
        //TODO
        Product product = new Product(1,"Muz",10);
        basketService.addProduct(product,5);
        basketService.decrementQuantity(product,3); // 3ürün çıkarıp

        assertThat(basketService.getBasket().getItems().get(0).getQuantity(),Matchers.equalTo(2)); // 2 ürün kaldıgını kontrol ettim
    }
    @Test
    public void shouldDecrementBasketItemQuantityAndRemoveWhenQuantityZero() throws Exception {
        //TODO

        Product product = new Product(1,"Armut",10);
        basketService.addProduct(product,5);
        basketService.decrementQuantity(product,5); // 3ürün çıkarıp

        assertThat(basketService.getBasket().getItems().size(),Matchers.equalTo(0));      //ürünüü sepetten çıkardı mı kontrolü
    }

    @Test
    public void shouldPriceBeZeroWhenBasketIsEmpty() throws Exception {
        //TODO sepet bosken total 0 olmalı
        assertTrue( basketService.getBasketPrice() == 0);
    }

    @Test
    public void shouldCalculateOneProductPrice() throws Exception {
        //TODO sepette 1 urun varken price hesaplanmali
        Product product = new Product(1,"Armut",99);
        basketService.addProduct(product,1);
        assertTrue(basketService.getBasketPrice().equals(product.getPrice()));
    }

    @Test
    public void shouldCalculateMultipleProductPrice() throws Exception {
        //TODO sepette coklu urun varken price hesaplanmali
        Product product = new Product(1,"Kalem",5);
        basketService.addProduct(product,3);
        Product product2 = new Product(2,"SamsungS7 ",10);
        basketService.addProduct(product2,5);

        assertTrue(basketService.getBasketPrice().equals((product.getPrice()*3) + (product2.getPrice() * 5)));
    }

    @Test
    public void shouldCalculateOneProductPriceAfterIncrement() throws Exception {
        //TODO sepette 1 urun varken sayisi arttirildiginda price hesaplanmali
        Product product = new Product(1,"Kalem",5);
        basketService.addProduct(product,3);
        basketService.incrementQuantity(product,2);
        assertThat(basketService.getBasketPrice(),Matchers.equalTo(25));
    }

    @Test
    public void shouldCalculateOneProductPriceAfterDecrement() throws Exception {
        //TODO sepette 1 urun varken sayisi azaltildiginda price hesaplanmali
        Product product = new Product(1,"Whey protein",5);
        basketService.addProduct(product,3);
        basketService.decrementQuantity(product,2);
        assertThat(basketService.getBasketPrice(),Matchers.equalTo(5));
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityIncrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi arttirma isleminden sonra price hesaplanmali
        Product product = new Product(1,"Casein Protein",200);
        basketService.addProduct(product,2);
        Product product2 = new Product(2,"Bcaa ",100);
        basketService.addProduct(product2,2);

        basketService.incrementQuantity(product,2);//800
        basketService.incrementQuantity(product2,1);//300

        assertTrue(basketService.getBasketPrice().equals(1100));
    }

    @Test
    public void shouldCalculatePriceWithMultipleProductAndOneQuantityDecrementOperation() throws Exception {
        //TODO sepette coklu urun varken ve bir sayi azaltma isleminden sonra price hesaplanmali
        Product product = new Product(1,"Dinitrophenol",500);
        basketService.addProduct(product,1);
        Product product2 = new Product(2,"Deca ",300);
        basketService.addProduct(product2,2);

        basketService.decrementQuantity(product,1);//0
        basketService.decrementQuantity(product2,1);//300

        assertTrue(basketService.getBasketPrice().equals(300));
    }


}