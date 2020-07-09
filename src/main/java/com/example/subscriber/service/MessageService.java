package com.example.subscriber.service;

import com.example.subscriber.dto.MessageDTO;
import com.example.subscriber.entity.Purchase;
import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.entity.Subscription;
import com.example.subscriber.helper.ActionType;
import com.example.subscriber.repository.PurchaseRepository;
import com.example.subscriber.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(MessageService.class);

    private SubscriberService subscriberService;

    private SubscriptionRepository subscriptionRepository;
    private PurchaseRepository purchaseRepository;

    @Autowired
    public MessageService(SubscriberService subscriberService, SubscriptionRepository subscriptionRepository, PurchaseRepository purchaseRepository) {
        this.subscriberService = subscriberService;
        this.subscriptionRepository = subscriptionRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public void saveMessage(MessageDTO message) {
        logger.info("saveMessage");
        Subscriber subscriber = subscriberService.getSubscriberOrSaveAndGet(message.getMsisdn());
        switch (message.getAction()) {
            case ActionType.purchase:
                logger.info("ActionType {}", ActionType.purchase);
                savePurchase(message.getTimestamp(), subscriber);
            case ActionType.subscription:
                logger.info("ActionType {}", ActionType.subscription);
                saveSubscription(message.getTimestamp(), subscriber);
        }
    }

    private void savePurchase(long timestamp, Subscriber subscriber) {
        logger.info("savePurchase");
        Purchase purchase = new Purchase();
        purchase.setSubscriber(subscriber);
        purchase.setTimestamp(timestamp);
        purchaseRepository.save(purchase);
    }

    private void saveSubscription(long timestamp, Subscriber subscriber) {
        logger.info("saveSubscription");
        Subscription subscription = new Subscription();
        subscription.setSubscriber(subscriber);
        subscription.setTimestamp(timestamp);
        subscriptionRepository.save(subscription);
    }
}
