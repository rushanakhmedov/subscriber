package com.example.subscriber.service;

import com.example.subscriber.entity.Purchase;
import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("purchaseService")
public class PurchaseService implements MessageSaver {

    Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void saveMessage(long timestamp, Subscriber subscriber) {
        logger.info("saveMessage");
        Purchase purchase = new Purchase();
        purchase.setSubscriber(subscriber);
        purchase.setTimestamp(timestamp);
        purchaseRepository.save(purchase);
    }
}
