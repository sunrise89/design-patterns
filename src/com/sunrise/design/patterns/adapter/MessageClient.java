package com.sunrise.design.patterns.adapter;

import java.util.Arrays;
import java.util.List;

public class MessageClient {

    public static void main(String[] args) {
        MessageService messageService = new MessageServiceImpl();
        User[] users = {new User("Suraj", "32", "M"), new User("Alex", "35", "F")};
        List<Object> messages = Arrays.asList(users);
        messages.forEach(message -> {
            messageService.sendMessageToTopic("testTopic", message);
            JsonMessageService jsonMessageService = new JsonMessageServiceImpl();
        });

        JsonMessageService jsonMessageService = new JsonMessageServiceImpl();
        MessageService messageAdapter = new StringMessageAdapter(jsonMessageService);

        messages.forEach(message -> {
            messageAdapter.sendMessageToTopic("testTopic", message);
        });

    }

}
