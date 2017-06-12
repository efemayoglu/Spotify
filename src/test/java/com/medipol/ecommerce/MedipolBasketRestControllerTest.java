package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
public class MedipolBasketRestControllerTest {



    @Test
    public void shouldAddProductToBasket() throws Exception {

        final MedipolBasketRestController controller = new MedipolBasketRestController();

        controller.addToBasket(1, 1);

    }
    @Test
    public void shouldCreateProductToBasket() throws Exception {

        final MedipolBasketRestController basketRestController = new MedipolBasketRestController();
        basketRestController.createBasket();

        final MedipolProductRestController productRestController = new MedipolProductRestController();
        Product product = productRestController.addProduct("soda",20);

        basketRestController.addToBasket(product.getId(), 1); // bu satırda hata alıyorum ??

        assertTrue(basketRestController.getBasketPrice().equals(20));

    }
    @Test
    public void shouldRemoveProductToBasket() throws Exception {

        final MedipolBasketRestController basketRestController = new MedipolBasketRestController();
        basketRestController.createBasket();

        final MedipolProductRestController productRestController = new MedipolProductRestController();
        Product product = productRestController.addProduct("soda",20);

        basketRestController.removeProduct(product.getId());

    }
    @Test
    public void shouldincrementQuantityProductToBasket() throws Exception {

        final MedipolBasketRestController basketRestController = new MedipolBasketRestController();
        basketRestController.createBasket();

        final MedipolProductRestController productRestController = new MedipolProductRestController();
        Product product = productRestController.addProduct("soda",20);
        basketRestController.addToBasket(product.getId(),1);
        basketRestController.incrementQuantity(product.getId(), 5);
        assertTrue(basketRestController.getBasketPrice().equals(120));
    }
    @Test
    public void shouldDecrementQuantityProductToBasket() throws Exception {

        final MedipolBasketRestController basketRestController = new MedipolBasketRestController();
        basketRestController.createBasket();

        final MedipolProductRestController productRestController = new MedipolProductRestController();
        Product product = productRestController.addProduct("soda",20);
        basketRestController.addToBasket(product.getId(),5);
        basketRestController.decrementQuantity(product.getId(), 2);
        assertTrue(basketRestController.getBasketPrice().equals(60));
    }
    @Test
    public void shouldgetBasketPriceProductToBasket() throws Exception {

        final MedipolBasketRestController basketRestController = new MedipolBasketRestController();
        basketRestController.createBasket();

        final MedipolProductRestController productRestController = new MedipolProductRestController();
        Product product = productRestController.addProduct("soda",20);
        basketRestController.addToBasket(product.getId(),5);

        assertTrue(basketRestController.getBasketPrice().equals(100));
    }

}