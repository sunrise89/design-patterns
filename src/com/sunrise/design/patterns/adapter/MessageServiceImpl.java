package com.sunrise.design.patterns.adapter;

public class MessageServiceImpl implements MessageService {
    @Override
    public void sendMessageToTopic(String topicName, Object message) {
        System.out.println("Sending message to string processing message broker" + message.toString());
    }
}
