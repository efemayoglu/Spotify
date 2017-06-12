package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.BasketItem;
import com.medipol.ecommerce.model.Product;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BasketTest {
    public  Basket basket = new Basket();

    @Test
    public void shouldAddProductWithOneQuantity() throws Exception {

         final Product product = new Product(1, "nike airmax", 200);

        basket.addItem(new BasketItem(1, product));

        assertTrue(basket.getItems().size() == 1);
        assertTrue(basket.getItems().get(0).getProduct().equals(product));

    }

    @Test
    public void shouldAddProductWithTwoQuantity() throws Exception {

      //TODO
        final Product product = new Product(1, "nike air force", 300);

        basket.addItem(new BasketItem(2, product));

        assertTrue(basket.getItems().get(0).getQuantity() == 2 );
        assertTrue(basket.getItems().get(0).getProduct().equals(product));

    }

    @Test
    public void shouldAddTwoDifferentProduct() throws Exception {
      //TODO

        final Product product = new Product(1, "Creatine", 100);
        final Product product2 = new Product(2, "Arginin ", 150);

        basket.addItem(new BasketItem(1,product));
        basket.addItem(new BasketItem(1,product2));
        assertThat(basket.getItems().size(), Matchers.equalTo(2));
    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductOneQuantity() throws Exception {

        //TODO
        final Product product = new Product(1, "Weider CFM proteintozu", 200);
        basket.addItem(new BasketItem(1,product));
        assertThat(basket.calculateBasketPrice(),Matchers.equalTo(200));
    }

    @Test
    public void shouldCalculateBasketPriceWithOneProductTwoQuantity() throws Exception {

        //TODO
        final Product product = new Product(1, "Optimmum proteintozu", 150);
        basket.addItem(new BasketItem(2,product));
        assertThat(basket.calculateBasketPrice(),Matchers.equalTo(300));
    }

    @Test
    public void shouldCalculateBasketPriceWithMultipleProduct() throws Exception {
        //TODO
        final Product product = new Product(1, "Multipower L-Karnitin", 100);
        final Product product2 = new Product(2, "Multipower Beta-Alanin", 200);
        basket.addItem(new BasketItem(1,product));
        basket.addItem(new BasketItem(1,product2));

        assertThat(basket.calculateBasketPrice(),Matchers.equalTo(300));

    }

    @Test
    public void shouldUpdateBasketItemQuantity() throws Exception {
        //TODO
        final Product product = new Product(1, "Granade NOX", 100);
        BasketItem basketItem = new BasketItem(1,product);
        basket.addItem(basketItem);
        basket.updateBasketItemQuantity(basketItem,5);

        assertTrue(basket.getItems().get(0).getQuantity() == 5);
    }

}