package com.example.subscriber.service;

import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

    private SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Subscriber getSubscriberOrSaveAndGet(long id) {
        Subscriber subscriber = subscriberRepository.findByMsisdn(id);
        if (subscriber == null) {
            Subscriber newSubscriber = new Subscriber();
            newSubscriber.setMsisdn(id);
            subscriberRepository.save(newSubscriber);
            return newSubscriber;
        }
        return subscriber;
    }
}
