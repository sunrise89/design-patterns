package com.sunrise.design.patterns.adapter;

public interface MessageService {
    public void sendMessageToTopic(String topicName, Object message);
}
