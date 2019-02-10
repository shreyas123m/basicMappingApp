package com.demo.basicApp.service;

import com.demo.basicApp.dao.ProductDAO;
import com.demo.basicApp.dto.ProductDTO;
import com.demo.basicApp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<ProductDTO> addProduct(List<Product> productList) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        productDAO.saveAll(productList).forEach(product -> productDTOS.add(marshal(product)));
        return productDTOS;
    }

    public ProductDTO marshal(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        return productDTO;
    }

}
