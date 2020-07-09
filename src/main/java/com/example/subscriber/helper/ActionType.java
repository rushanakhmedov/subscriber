package com.example.subscriber.helper;

import org.springframework.stereotype.Component;

@Component
public class ActionType {
    public static final String purchase = "PURCHASE";
    public static final String subscription = "SUBSCRIPTION";

    public static final String pattern = purchase + "|" + subscription;
}
