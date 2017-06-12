package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Product;

import java.util.List;

public interface Medify {

    void createProduct(Integer id, String name, Integer price);
    List<Product> findAllProducts();


}
