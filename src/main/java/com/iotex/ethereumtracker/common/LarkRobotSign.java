package com.iotex.ethereumtracker.common;

import com.iotex.ethereumtracker.Constants.Constants;
import com.iotex.ethereumtracker.model.GenSignBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class LarkRobotSign {

    public GenSignBO genSign() {
        Long timestamp = System.currentTimeMillis() / 1000;
        String stringToSign = timestamp + "\n" + Constants.SECRET;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(stringToSign.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(new byte[]{});
            GenSignBO genSignBO = new GenSignBO();
            genSignBO.setSign(new String(Base64.encodeBase64(signData)));
            genSignBO.setTimestamp(timestamp);
            return genSignBO;
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            log.warn(String.valueOf(e));
            return null;
        }
    }
}
