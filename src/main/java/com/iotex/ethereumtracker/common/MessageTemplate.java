package com.iotex.ethereumtracker.common;

import com.alibaba.fastjson.JSONObject;
import com.iotex.ethereumtracker.Constants.Constants;
import com.iotex.ethereumtracker.model.GenSignBO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MessageTemplate {
    private String message;
    private String title;
    private String url;
    private String commitId;

    public String initMessage() {
        return initBody().toString();
    }


    private JSONObject initBody() {
        LarkRobotSign larkRobotSign = new LarkRobotSign();
        GenSignBO genSignBO = larkRobotSign.genSign();
        String sign = genSignBO.getSign();
        Long timestamp = genSignBO.getTimestamp();

        JSONObject body = new JSONObject();
        body.put("msg_type", "post");
        body.put("sign", sign);
        body.put("timestamp", timestamp);
        body.put("content", initContent());
        return body;
    }

    private JSONObject initContent() {
        JSONObject content = new JSONObject();
        content.put("post", initPost());
        return content;

    }

    private JSONObject initPost() {
        JSONObject post = new JSONObject();
        post.put("zh_cn", initZh_cn());
        return post;
    }

    private JSONObject initZh_cn() {
        JSONObject zh_cn = new JSONObject();
        zh_cn.put("title", "Ethereum-go project created a new " + title + " alert");
        zh_cn.put("content", initZh_cn_content());
        return zh_cn;
    }

    private List<List<JSONObject>> initZh_cn_content() {
        List<List<JSONObject>> zh_cn_content = new ArrayList<>();
        zh_cn_content.add(initZh_cn_data());

        return zh_cn_content;

    }

    public List<JSONObject> initZh_cn_data() {
        JSONObject zh_cn_data1 = new JSONObject();
        zh_cn_data1.put("tag", "text");
        zh_cn_data1.put("text", "new " + title + ": ");
        JSONObject zh_cn_data2 = new JSONObject();
        zh_cn_data2.put("tag", "a");
        zh_cn_data2.put("text", message);
        if (title.equals("branch") || title.equals("tag")) {
            zh_cn_data2.put("href", Constants.ETHEREUMURL + url + message);
        }
        if (title.equals("final")) {
            zh_cn_data2.put("href", Constants.EIPSSTATUSURL + url);
        } else {
            zh_cn_data2.put("href", Constants.ETHEREUMURL + url + commitId);
        }

        List<JSONObject> zh_cn_data = new ArrayList<>();
        zh_cn_data.add(zh_cn_data1);
        zh_cn_data.add(zh_cn_data2);
        return zh_cn_data;
    }

}
