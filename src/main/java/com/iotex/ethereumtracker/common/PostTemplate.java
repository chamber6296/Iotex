package com.iotex.ethereumtracker.common;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@Slf4j
public class PostTemplate {
    public static void initPost(String url, String body) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity se = new StringEntity(body, "utf-8");
        httpPost.setEntity(se);
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            httpClient.close();
        } catch (IOException e) {
            log.warn(String.valueOf(e));
        }
    }
}
