package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.junit.Test;


import java.util.List;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductServiceTest {


    @Test
    public void shouldListInitialProducts() throws Exception {
        //TODO
        List<Product> list = new ProductService().list();
        assertTrue(list.size() == 2);
    }

    @Test
    public void shouldAddOneProduct() throws Exception {
        //TODO
        Product product = new ProductService().add("Mouse Pad",5);
        assertFalse(!product.getName().equalsIgnoreCase("mouse pad"));
    }

    @Test
    public void shouldMultipleOneProduct() throws Exception {
        //Birden cok bir urun olmalidir diye cevirdim
        //TODO
        ProductService productService = new ProductService();

        Product product = new ProductService().add("Mouse Pad",5);
        Product product2 = new ProductService().add("Mouse",50);
        productService.add(product.getName(),product.getPrice());
        productService.add(product2.getName(),product2.getPrice());
/*
        int size = productService.list()
                .stream()
                .filter(x->x.getName().equalsIgnoreCase("Mouse Pad") && x.getPrice().equals(5))
                .collect(Collectors.toList()).size();
                 eski hali */
        int size = productService.list().size();
        assertTrue(size == 4);// 2 tane örnek veri oldugundan toplam 4
    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        //TODO
        ProductService productService = new ProductService();

        Product product = productService.add("Marshall Major II Kulaklik",10);
        productService.delete(product.getId());
        assertFalse(productService.list().contains(product)); //compiles, but fails
        //saçma şekilde hata verdigi için tostringi integar a parse ettim

    }

    @Test
    public void shouldUpdateProductName() throws Exception {
        //TODO
        ProductService productService = new ProductService();
        Product product = productService.add("Laptop",5);
        String new_productName = "Dizustu PC";

        productService.update(product.getId(),new_productName,product.getPrice());

        Product testProduct = productService.findBy(product.getId());

        assertTrue(testProduct.getName().equalsIgnoreCase("Dizustu pc"));
    }

    @Test
    public void shouldUpdateProductPrice() throws Exception {
        //TODO
        ProductService productService = new ProductService();

        Product product = productService.add("Laptop",5);

        int new_productPrice = 20;

        productService.update(product.getId(),product.getName(),new_productPrice);

        Product testProduct = productService.findBy(product.getId());

        assertTrue(testProduct.getPrice().equals(20));
    }

    @Test
    public void shouldUpdateProductNameAndPrice() throws Exception {
        //TODO
        ProductService productService = new ProductService();
        Product product = productService.add("Soda",10);

        String new_productName = "Gazoz";

        int new_productPrice = 30;

        productService.update(product.getId(),new_productName,new_productPrice);

        Product testProduct = productService.findBy(product.getId());

        assertFalse(!testProduct.getName().equalsIgnoreCase("Soda") && !testProduct.getPrice().equals(30));
    }

}