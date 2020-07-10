package com.example.subscriber.service;

import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.helper.ActionType;

public interface MessageProcessor {

    ActionType getProcessingType();

    void saveMessage(long timestamp, Subscriber subscriber);

}
