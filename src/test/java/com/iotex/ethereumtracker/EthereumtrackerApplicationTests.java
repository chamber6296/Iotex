package com.iotex.ethereumtracker;

import com.alibaba.fastjson.JSONObject;
import com.iotex.ethereumtracker.common.InitHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@SpringBootTest
class EthereumtrackerApplicationTests {

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        decode();
    }

    private static void decode() throws UnsupportedEncodingException {
//        InitHttpClient initHttpClient = new InitHttpClient();
//        String response = initHttpClient.InitClient("https://api.github.com/repos/ethereum/EIPs/contents/EIPS/eip-100.md").body();
//
//        EipsBO eipsBO = JSONObject.parseObject(response, EipsBO.class);
//
//        System.out.println(eipsBO.getContent());

        byte[] base64Data = Base64.getDecoder().decode("LS0tCmVpcDogMTAwCnRpdGxlOiBDaGFuZ2UgZGlmZmljdWx0eSBhZGp1c3RtZW50IHRvIHRhcmdldCBtZWFuIGJsb2NrIHRpbWUgaW5jbHVkaW5nIHVuY2xlcwphdXRob3I6IFZpdGFsaWsgQnV0ZXJpbiAoQHZidXRlcmluKQp0eXBlOiBTdGFuZGFyZHMgVHJhY2sKY2F0ZWdvcnk6IENvcmUKc3RhdHVzOiBGaW5hbApjcmVhdGVkOiAyMDE2LTA0LTI4Ci0tLQoKIyMjIFNwZWNpZmljYXRpb24KCkN1cnJlbnRseSwgdGhlIGZvcm11bGEgdG8gY29tcHV0ZSB0aGUgZGlmZmljdWx0eSBvZiBhIGJsb2NrIGluY2x1ZGVzIHRoZSBmb2xsb3dpbmcgbG9naWM6CgpgYGAgcHl0aG9uCmFkal9mYWN0b3IgPSBtYXgoMSAtICgodGltZXN0YW1wIC0gcGFyZW50LnRpbWVzdGFtcCkgLy8gMTApLCAtOTkpCmNoaWxkX2RpZmYgPSBpbnQobWF4KHBhcmVudC5kaWZmaWN1bHR5ICsgKHBhcmVudC5kaWZmaWN1bHR5IC8vIEJMT0NLX0RJRkZfRkFDVE9SKSAqIGFkal9mYWN0b3IsIG1pbihwYXJlbnQuZGlmZmljdWx0eSwgTUlOX0RJRkYpKSkKLi4uCmBgYAoKSWYgYGJsb2NrLm51bWJlciA+PSBCWVpBTlRJVU1fRk9SS19CTEtOVU1gLCB3ZSBjaGFuZ2UgdGhlIGZpcnN0IGxpbmUgdG8gdGhlIGZvbGxvd2luZzoKCmBgYCBweXRob24KYWRqX2ZhY3RvciA9IG1heCgoMiBpZiBsZW4ocGFyZW50LnVuY2xlcykgZWxzZSAxKSAtICgodGltZXN0YW1wIC0gcGFyZW50LnRpbWVzdGFtcCkgLy8gOSksIC05OSkKYGBgCiMjIyBSYXRpb25hbGUKClRoaXMgbmV3IGZvcm11bGEgZW5zdXJlcyB0aGF0IHRoZSBkaWZmaWN1bHR5IGFkanVzdG1lbnQgYWxnb3JpdGhtIHRhcmdldHMgYSBjb25zdGFudCBhdmVyYWdlIHJhdGUgb2YgYmxvY2tzIHByb2R1Y2VkIGluY2x1ZGluZyB1bmNsZXMsIGFuZCBzbyBlbnN1cmVzIGEgaGlnaGx5IHByZWRpY3RhYmxlIGlzc3VhbmNlIHJhdGUgdGhhdCBjYW5ub3QgYmUgbWFuaXB1bGF0ZWQgdXB3YXJkIGJ5IG1hbmlwdWxhdGluZyB0aGUgdW5jbGUgcmF0ZS4gQSBmb3JtdWxhIHRoYXQgYWNjb3VudHMgZm9yIHRoZSBleGFjdCBudW1iZXIgb2YgaW5jbHVkZWQgdW5jbGVzOgpgYGAgcHl0aG9uCmFkal9mYWN0b3IgPSBtYXgoMSArIGxlbihwYXJlbnQudW5jbGVzKSAtICgodGltZXN0YW1wIC0gcGFyZW50LnRpbWVzdGFtcCkgLy8gOSksIC05OSkKYGBgCmNhbiBiZSBmYWlybHkgZWFzaWx5IHNlZW4gdG8gYmUgKHRvIHdpdGhpbiBhIHRvbGVyYW5jZSBvZiB+My80MTk0MzA0KSBtYXRoZW1hdGljYWxseSBlcXVpdmFsZW50IHRvIGFzc3VtaW5nIHRoYXQgYSBibG9jayB3aXRoIGBrYCB1bmNsZXMgaXMgZXF1aXZhbGVudCB0byBhIHNlcXVlbmNlIG9mIGBrKzFgIGJsb2NrcyB0aGF0IGFsbCBhcHBlYXIgd2l0aCB0aGUgZXhhY3Qgc2FtZSB0aW1lc3RhbXAsIGFuZCB0aGlzIGlzIGxpa2VseSB0aGUgc2ltcGxlc3QgcG9zc2libGUgd2F5IHRvIGFjY29tcGxpc2ggdGhlIGRlc2lyZWQgZWZmZWN0LiBCdXQgc2luY2UgdGhlIGV4YWN0IGZvcm11bGEgZGVwZW5kcyBvbiB0aGUgZnVsbCBibG9jayBhbmQgbm90IGp1c3QgdGhlIGhlYWRlciwgd2UgYXJlIGluc3RlYWQgdXNpbmcgYW4gYXBwcm94aW1hdGUgZm9ybXVsYSB0aGF0IGFjY29tcGxpc2hlcyBhbG1vc3QgdGhlIHNhbWUgZWZmZWN0IGJ1dCBoYXMgdGhlIGJlbmVmaXQgdGhhdCBpdCBkZXBlbmRzIG9ubHkgb24gdGhlIGJsb2NrIGhlYWRlciAoYXMgeW91IGNhbiBjaGVjayB0aGUgdW5jbGUgaGFzaCBhZ2FpbnN0IHRoZSBibGFuayBoYXNoKS4KCkNoYW5naW5nIHRoZSBkZW5vbWluYXRvciBmcm9tIDEwIHRvIDkgZW5zdXJlcyB0aGF0IHRoZSBibG9jayB0aW1lIHJlbWFpbnMgcm91Z2hseSB0aGUgc2FtZSAoaW4gZmFjdCwgaXQgc2hvdWxkIGRlY3JlYXNlIGJ5IH4zJSBnaXZlbiB0aGUgY3VycmVudCB1bmNsZSByYXRlIG9mIDclKS4KCiMjIyBSZWZlcmVuY2VzCgoxLiBFSVAgMTAwIGlzc3VlIGFuZCBkaXNjdXNzaW9uOiBodHRwczovL2dpdGh1Yi5jb20vZXRoZXJldW0vRUlQcy9pc3N1ZXMvMTAwCjIuIGh0dHBzOi8vYml0c2xvZy53b3JkcHJlc3MuY29tLzIwMTYvMDQvMjgvdW5jbGUtbWluaW5nLWFuLWV0aGVyZXVtLWNvbnNlbnN1cy1wcm90b2NvbC1mbGF3Lwo=");

        String str = new String(base64Data, "utf-8");
        System.out.println(str);
    }

}




