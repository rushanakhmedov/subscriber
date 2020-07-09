package com.example.subscriber.service;

import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.entity.Subscription;
import com.example.subscriber.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("subscriptionService")
public class SubscriptionService implements MessageSaver {

    Logger logger = LoggerFactory.getLogger(SubscriptionService.class);

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {

        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void saveMessage(long timestamp, Subscriber subscriber) {
        logger.info("saveMessage");
        Subscription subscription = new Subscription();
        subscription.setSubscriber(subscriber);
        subscription.setTimestamp(timestamp);
        subscriptionRepository.save(subscription);
    }
}
