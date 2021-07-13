package com.sunrise.design.patterns.adapter;

public class StringMessageAdapter implements MessageService {

    private JsonMessageService jsonMessageService;

    public StringMessageAdapter(JsonMessageService jsonMessageService) {
        this.jsonMessageService = jsonMessageService;
    }

    @Override
    public void sendMessageToTopic(String topicName, Object message) {
        MessageInfo messageInfo = new MessageInfo(topicName, message.toString());
        jsonMessageService.send(messageInfo);
    }
}
