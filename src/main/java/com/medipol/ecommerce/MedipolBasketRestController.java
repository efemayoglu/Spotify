package com.medipol.ecommerce;

import com.medipol.ecommerce.model.Basket;
import com.medipol.ecommerce.model.Product;
import com.medipol.ecommerce.service.BasketService;
import com.medipol.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/basket")//TODO
@RestController
public class MedipolBasketRestController {

    @Autowired private  BasketService basketService = new BasketService();
    @Autowired private ProductService productService = new ProductService();
    //addToBasket
    @RequestMapping(path = "/addToBasket")
    public Basket addToBasket(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product, quantity);
        return basketService.getBasket();

    }

    //createBasket
    @RequestMapping(path = "/createBasket")
    public Basket createBasket() {
        basketService.createBasket();
        return basketService.getBasket();
    }


    //getBasketDetail
    @RequestMapping(path = "/getBasketDetail")
    public void getBasketDetail(@RequestParam int id) {
      //???
          basketService.printBasketDetail();
    }

    //removeProduct
    @RequestMapping(path = "/removeProduct")
    public boolean removeProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if (product!=null){
            basketService.removeBasketItemBy(product);
            return true;
        }

        return false;
    }
    //incrementQuantity
    @RequestMapping(path = "/incrementQuantity")
    public boolean incrementQuantity(@RequestParam int id,@RequestParam int quantity) {
        Product product = productService.findBy(id);
        if (product!=null){
            basketService.incrementQuantity(product,quantity);
            return true;
        }

        return false;
    }
    //decrementQuantity
    @RequestMapping(path = "/decrementQuantity")
    public boolean decrementQuantity(@RequestParam int id,@RequestParam int quantity) {
        Product product = productService.findBy(id);
        if (product!=null){
            basketService.decrementQuantity(product,quantity);
            return true;
        }

        return false;
    }

    //getBasketPrice
    @RequestMapping(path = "/getBasketPrice")
    public Integer getBasketPrice() {
       Basket basket = basketService.getBasket();
       return basket.calculateBasketPrice();

    }
}
