package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")//TODO
@RestController
public class MedipolProductRestController {

    @Autowired private ProductService productService = new ProductService();
    //add
    @RequestMapping(path = "/addProduct")
    public Product addProduct(@RequestParam String name, @RequestParam int price) {
        Product product = productService.add(name,price);
        return product;

    }
    //delete
    @RequestMapping(path = "/deleteProduct")
    public boolean deleteProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if (product != null){
            productService.delete(id);
            return true;
        }
        return false;
    }
    //update
    @RequestMapping(path = "/updateProduct")
    public Product updateProduct(@RequestParam int id,@RequestParam String name, @RequestParam int price) {
        Product product = productService.findBy(id);
        if (product!=null){
            product.setName(name);
            product.setPrice(price);
            return product;
        }
        return null;
    }
    //list
    @RequestMapping(path = "/listProduct")
    public List<Product> listProduct() {
       return productService.list();
    }
    //findById
    @RequestMapping(path = "/findProduct")
    public Product findProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if(product!=null)
            return product;
        return null;
    }
}
