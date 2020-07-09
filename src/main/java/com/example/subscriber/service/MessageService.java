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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(MessageService.class);

    private ApplicationContext context;

    private SubscriberService subscriberService;

    private SubscriptionRepository subscriptionRepository;
    private PurchaseRepository purchaseRepository;

    @Autowired
    public MessageService(ApplicationContext context, SubscriberService subscriberService, SubscriptionRepository subscriptionRepository, PurchaseRepository purchaseRepository) {
        this.context = context;
        this.subscriberService = subscriberService;
        this.subscriptionRepository = subscriptionRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public void saveMessage(MessageDTO message) {
        Subscriber subscriber = subscriberService.getSubscriberOrSaveAndGet(message.getMsisdn());

        MessageSaver messageSaverService = context.getBean(ActionType.purchase.toLowerCase() + "Service", MessageSaver.class);
        messageSaverService.saveMessage(message.getTimestamp(), subscriber);
    }
}
