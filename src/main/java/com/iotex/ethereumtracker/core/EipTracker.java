package com.iotex.ethereumtracker.core;

import com.iotex.ethereumtracker.Constants.Constants;
import com.iotex.ethereumtracker.common.SentMessageToLark;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class EipTracker {

    @Scheduled(fixedDelay = 86400000)
    public void eipTracker() {
        trackerFinalEip();
    }

    private static final Set<String> eipSet = new HashSet<>();
    SentMessageToLark sentMessageToLark = new SentMessageToLark();

    private Elements getFinalEip() {

        try {
            //获取所有EIP html文件
            Document doc = Jsoup.connect(Constants.EIPSURL).get();
            //获取所有eipTable
            Elements table = doc.getElementsByClass("eiptable");

            //获取final状态的eipTable
            Element finalEip = table.get(1);

            //获取final状态的eipTable的所有tr
            Elements trs = finalEip.select("tr");

            //删除final状态的eipTable的thead tr
            trs.remove(0);

            return trs;

        } catch (IOException e) {
            log.warn(String.valueOf(e));
            return null;
        }

    }

    @PostConstruct
    private void initFinalEip() {

        Elements trs = getFinalEip();

        //获取final状态的eip信息
        assert trs != null;
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            String eipNum = tds.get(0).text();
            eipSet.add(eipNum);

        }

    }

    private void trackerFinalEip() {
        Elements trs = getFinalEip();
        //获取final状态的eip信息
        assert trs != null;
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            String eipNum = tds.get(0).text();
            if (!eipSet.contains(eipNum)) {
                String eipUrl = "/EIPS/eip-" + eipNum;
                String eipTitle = tds.get(1).text();
                eipSet.add(eipNum);
                sentMessageToLark.sentMessage(eipTitle, "final", eipUrl);
            }
        }
    }

}
