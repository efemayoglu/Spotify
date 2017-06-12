package com.medipol.ecommerce.service;

import com.medipol.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>();

    private int id=1;
    public ProductService() {

        products.add(new Product(id++, "nike air", 200));
        products.add(new Product(id++, "addidas", 300));
    }

    public Product add(String name, Integer price){
        //TODO
        Product product = new Product(id++, name, price);
        products.add(product);
        return product;
    }

    public void delete(Integer id) {
        //TODO
        products.remove(products.stream().filter(x->x.getId().equals(id)).findFirst().get());
        for (Product product:products)
            System.out.println(product.getName());
    }

    public void update(Integer id, String name, Integer price){
        //TODO
      //  Product new_product = new Product(this.id++,name,price);
//        Product old_product = products.stream().filter(x->x.getId().equals(id)).findFirst().get();
        for (Product product: products)
            if (product.getId().equals(id)){
                product.setName(name);
                product.setPrice(price);
            }

    }

    public List<Product> list(){
        return products;
    }

    public Product findBy(int productId) {
        //TODO
        Product product = products.stream().filter(x->x.getId().equals(productId)).findFirst().get();
        return product;
    }
}
