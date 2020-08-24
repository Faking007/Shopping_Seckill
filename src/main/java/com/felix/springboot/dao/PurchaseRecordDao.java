package com.felix.springboot.dao;

import com.felix.springboot.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRecordDao {
    int insertPurchaseRecord(PurchaseRecord purchaseRecord);
}
