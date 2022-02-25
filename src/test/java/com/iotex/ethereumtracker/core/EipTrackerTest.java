package com.iotex.ethereumtracker.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

class EipTrackerTest {

    public static void main(String[] args) throws IOException {
        getAllFinalEip();
    }

    private static void getAllFinalEip() throws IOException {

        //获取所有EIP html文件
        Document doc = Jsoup.connect("https://eips.ethereum.org/all").get();

        //获取所有eipTable
        Elements table = doc.getElementsByClass("eiptable");

        //获取final状态的eipTable
        Element finalEip = table.get(1);

        //获取final状态的eipTable的所有tr
        Elements trs = finalEip.select("tr");

        //删除final状态的eipTable的thead tr
        trs.remove(0);

        //获取final状态的eip信息
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            String eipNum = tds.get(0).text();
            String eipUrl = "/EIPS/eip-" + eipNum;
            String eipTitle = tds.get(1).text();
            System.out.println(eipNum);
            System.out.println(eipUrl);
            System.out.println(eipTitle);
        }

    }

}