package com.example.subscriber.service;

import com.example.subscriber.dto.MessageDTO;
import com.example.subscriber.entity.Subscriber;

public interface MessageSaver {

    void saveMessage(long timestamp, Subscriber subscriber);

}
