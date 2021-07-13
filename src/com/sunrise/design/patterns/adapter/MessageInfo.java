package com.sunrise.design.patterns.adapter;

public class MessageInfo {
    private String topicName;
    private String payLoad;

    public MessageInfo(String topicName, String payLoad) {
        this.topicName = topicName;
        this.payLoad = payLoad;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }
}
