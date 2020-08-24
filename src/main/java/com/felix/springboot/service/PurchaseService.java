package com.felix.springboot.service;

import com.felix.springboot.dao.PurchaseRecordDao;
import com.felix.springboot.pojo.Product;
import com.felix.springboot.pojo.PurchaseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseRecordDao purchaseRecordDao;

    @Transactional
    public boolean purchase(Long userId, Long productId, int quantity) {
        Product product = productService.getProduct(productId);
        if (product.getStock() < quantity) {
            return false;
        }
        productService.decreaseProduct(productId, quantity);
        purchaseRecordDao.insertPurchaseRecord(initPurchaseRecord(userId, product, quantity));
        return true;
    }

    private PurchaseRecord initPurchaseRecord(Long userId, Product product, int quantity) {
        PurchaseRecord purchaseRecord = new PurchaseRecord();
        purchaseRecord.setProductId(product.getId());
        purchaseRecord.setPrice(product.getPrice());
        purchaseRecord.setQuantity(quantity);
        purchaseRecord.setSum(product.getPrice() * quantity);
        purchaseRecord.setUserId(userId);
        purchaseRecord.setNote("Purchase log, time: " + System.currentTimeMillis());
        return purchaseRecord;
    }
}
