package com.felix.springboot.controller;

import com.felix.springboot.pojo.Product;
import com.felix.springboot.service.ProductService;
import com.felix.springboot.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    @PostMapping("/purchase")
    public ResponseEntity<Product> purchase(Long userId, Long productId, Integer quantity) {
        boolean result = purchaseService.purchase(userId, productId, quantity);
        if (result) {
            Product product = productService.getProduct(productId);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
