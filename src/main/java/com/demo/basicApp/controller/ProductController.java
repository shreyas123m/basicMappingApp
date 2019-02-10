package com.demo.basicApp.controller;
import com.demo.basicApp.dto.ProductDTO;
import com.demo.basicApp.model.Product;
import com.demo.basicApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1")
public class ProductController {

    @Autowired
    ProductService productService;
    //Insert Product
    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public List<ProductDTO> insertProduct() {
        //Add products
        Product prod1 = new Product();
        prod1.setProductName("Hair Dryer");
        prod1.setProductPrice(23.00);

        Product prod2 = new Product();
        prod2.setProductName("Shampoo");
        prod2.setProductPrice(13.00);

        Product prod3 = new Product();
        prod3.setProductName("Lotion");
        prod3.setProductPrice(5.50);

        Product prod4 = new Product();
        prod4.setProductName("Deo");
        prod4.setProductPrice(20.30);

        List<Product> productList = new ArrayList<>(Arrays.asList(
                prod1,
                prod2,
                prod3,
                prod4
        ));
        return productService.addProduct(productList);
    }

}
