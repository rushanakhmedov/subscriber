package com.example.subscriber.service;

import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriberService {

    private SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Subscriber getSubscriberOrSaveAndGet(long id) {
        Optional<Subscriber> subscriberOptional = subscriberRepository.findByMsisdn(id);
        if (subscriberOptional.isEmpty()) {
            Subscriber newSubscriber = new Subscriber();
            newSubscriber.setMsisdn(id);
            subscriberRepository.save(newSubscriber);
            return newSubscriber;
        }
        return subscriberOptional.get();
    }
}
