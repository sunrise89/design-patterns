package com.sunrise.design.patterns.adapter;

public class JsonMessageServiceImpl implements JsonMessageService {
    @Override
    public void send(MessageInfo messageInfo) {
        System.out.println("Sending message to json processing message broker"+messageInfo.getPayLoad());
    }
}
