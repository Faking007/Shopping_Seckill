package com.felix.springboot.dao;

import com.felix.springboot.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao {
    Product getProduct(Long id);

    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
