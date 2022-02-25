package com.iotex.ethereumtracker.common;

import com.iotex.ethereumtracker.Constants.Constants;

public class SentMessageToLark {

    public void sentMessage(String message, String title, String url) {
        MessageTemplate messageTemplate = new MessageTemplate();
        messageTemplate.setMessage(message);
        messageTemplate.setTitle(title);
        messageTemplate.setUrl(url);
        String body = messageTemplate.initMessage();
        PostTemplate.initPost(Constants.LARKROBOTRUL, body);
    }
}
