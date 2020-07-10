package com.example.subscriber.service;

import com.example.subscriber.dto.MessageDTO;
import com.example.subscriber.entity.Subscriber;
import com.example.subscriber.helper.ActionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    Logger logger = LoggerFactory.getLogger(MessageService.class);

    private SubscriberService subscriberService;
    private List<MessageProcessor> messageProcessors;

    @Autowired
    public MessageService(SubscriberService subscriberService, List<MessageProcessor> messageProcessors) {
        this.subscriberService = subscriberService;
        this.messageProcessors = messageProcessors;
    }

    public void saveMessage(MessageDTO message) {
        Subscriber subscriber = subscriberService.getSubscriberOrSaveAndGet(message.getMsisdn());
        ActionType actionType = message.getAction();

        logger.info("Save message for subscriber msisdn: {}", subscriber.getMsisdn());

        MessageProcessor messageProcessor = messageProcessors.stream()
                .filter(processor -> processor.getProcessingType().equals(actionType))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported type " + actionType));

        messageProcessor.saveMessage(message.getTimestamp(), subscriber);
    }
}
