package com.iotex.ethereumtracker.common;

import com.alibaba.fastjson.JSONObject;
import com.iotex.ethereumtracker.Constants.Constants;
import com.iotex.ethereumtracker.model.EthereumCommit;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class GetCommit {
    private static final Set<String> commitsSet = new HashSet<>();

    public void CommitTracker(String path) {
        InitHttpClient initHttpClient = new InitHttpClient();
        String response = initHttpClient.InitClient(Constants.COMMITBASERUL + path).body();
        List<EthereumCommit> commitList = JSONObject.parseArray(response, EthereumCommit.class);
        if (commitList.size() == 0) {
            log.info(path + " 目录下未发现新commit");
            return;
        }

        for (EthereumCommit commit : commitList) {
            if (!commitsSet.contains(commit.getSha())) {
                commitsSet.add(commit.getSha());
                MessageTemplate messageTemplate = new MessageTemplate();
                messageTemplate.setMessage(commit.getCommit().getMessage());
                messageTemplate.setTitle("commit");
                messageTemplate.setUrl("commit/");
                messageTemplate.setCommitId(commit.getSha());
                String body = messageTemplate.initMessage();
                PostTemplate.initPost(Constants.LARKROBOTRUL, body);
            }

        }

    }
}
