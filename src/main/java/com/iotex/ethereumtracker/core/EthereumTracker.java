package com.iotex.ethereumtracker.core;

import com.alibaba.fastjson.JSONObject;
import com.iotex.ethereumtracker.Constants.Constants;
import com.iotex.ethereumtracker.common.GetCommit;
import com.iotex.ethereumtracker.common.InitHttpClient;
import com.iotex.ethereumtracker.common.SentMessageToLark;
import com.iotex.ethereumtracker.model.EthereumBranch;
import com.iotex.ethereumtracker.model.EthereumTag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class EthereumTracker {

    @Scheduled(fixedDelay = 60000)
    public void tracker() {
        branchAndTagTracker();
        commonCommitTracker();
        coreCommitTracker();
        coreStateCommitTracker();
        coreTypesCommitTracker();
        coreVmCommitTracker();
        coreVmRuntimeCommitTracker();
        ethClientCommitTracker();
        paramsConfigCommitTracker();
    }

    private static final Set<String> branchesSet = new HashSet<>();
    private static final Set<String> tagsSet = new HashSet<>();

    InitHttpClient initHttpClient = new InitHttpClient();
    GetCommit getCommit = new GetCommit();
    SentMessageToLark sentMessageToLark = new SentMessageToLark();

    @PostConstruct
    private void getBranchesAndTags() {

        //获取所有branch
        String branchResponse = initHttpClient.InitClient(Constants.BRANCHURL + "?per_page=100").body();
        List<EthereumBranch> ethereumBranchesList = JSONObject.parseArray(branchResponse, EthereumBranch.class);
        for (EthereumBranch branches : ethereumBranchesList) {
            branchesSet.add(branches.getName());
        }

        //获取所有tag
        for (int page = 1; page <= 3; page++) {
            String tagResponse = initHttpClient.InitClient(Constants.TAGURL + "?per_page=100&page=" + page).body();
            List<EthereumTag> ethereumTagsList = JSONObject.parseArray(tagResponse, EthereumTag.class);
            for (EthereumTag tag : ethereumTagsList) {
                tagsSet.add(tag.getName());
            }
        }
    }

    //获取新branch
    private void branchAndTagTracker() {

        //tacker branch
        String branchResponse = initHttpClient.InitClient(Constants.BRANCHURL + "?per_page=1").body();
        List<EthereumBranch> ethereumBranchesList = JSONObject.parseArray(branchResponse, EthereumBranch.class);
        String branchName = ethereumBranchesList.get(0).getName();
        if (!branchesSet.contains(branchName)) {
            //将新分支发送到Lark机器人:
            sentMessageToLark.sentMessage(branchName, "branch", "tree/");

            //将新分支写入set:
            branchesSet.add(branchName);
        } else {
            log.info("未发现新分支");
        }

        //tracker tag
        String tagResponse = initHttpClient.InitClient(Constants.TAGURL + "?per_page=1").body();
        List<EthereumTag> ethereumTagList = JSONObject.parseArray(tagResponse, EthereumTag.class);
        String tag = ethereumTagList.get(0).getName();
        if (!tagsSet.contains(tag)) {
            //将新分支发送到Lark机器人:
            sentMessageToLark.sentMessage(tag, "tag", "releases/tag/");

            //将新分支写入set:
            tagsSet.add(tag);
        } else {
            log.info("未发现新tag");
        }

    }


    //获取common/*.go的新commit:
    private void commonCommitTracker() {
        getCommit.CommitTracker("common");

    }

    //获取core/*.go的新commit:
    private void coreCommitTracker() {
        getCommit.CommitTracker("core");

    }

    //获取core/state/*.go的新commit:
    private void coreStateCommitTracker() {
        getCommit.CommitTracker("core/state");

    }

    //获取core/types/*.go的新commit:
    private void coreTypesCommitTracker() {
        getCommit.CommitTracker("core/types");

    }

    //获取core/vm/*.go的新commit:
    private void coreVmCommitTracker() {
        getCommit.CommitTracker("core/vm");

    }

    //获取core/vm/runtime/*.go的新commit:
    private void coreVmRuntimeCommitTracker() {
        getCommit.CommitTracker("core/vm/runtime");

    }

    //获取ethClient/*.go的新commit:
    private void ethClientCommitTracker() {
        getCommit.CommitTracker("ethclient");

    }

    //获取params/config.go的新commit:
    private void paramsConfigCommitTracker() {
        getCommit.CommitTracker("params/config.go");

    }

}
