package org.geekbang.week.two.nio.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 描述:
 *
 * @author lil
 */
public class HttpClientTool {
    private HttpClientTool() {
    }

    // GET 调用
    public static String httpGet(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            HttpEntity entity1 = response.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        }
    }
}
