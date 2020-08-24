package com.felix.springboot.service;

import com.felix.springboot.dao.ProductDao;
import com.felix.springboot.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    public int decreaseProduct(Long id, int quantity) {
        return productDao.decreaseProduct(id, quantity);
    }
}
