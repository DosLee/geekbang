package org.geekbang.week.nine.rpcfx;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.geek.rpcfx.api.RpcfxRequest;
import org.geek.rpcfx.api.RpcfxResponse;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 描述:
 *
 * @author lil
 */
@Slf4j
public class RpcfxInvocationHandler implements InvocationHandler {

    private final Class<?> serviceClass;
    private final String url;

    public <T> RpcfxInvocationHandler(Class<T> serviceClass, String url) {
        this.serviceClass = serviceClass;
        this.url = url;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(this.serviceClass.getName());
        request.setMethod(method.getName());
        request.setParams(args);
        RpcfxResponse response = post(request, url);
        return JSON.parse(response.getResult().toString());
    }

    private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        log.info("req json: {}", reqJson);
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.get("application/json; charset=utf-8"),reqJson))
                .build();
        String respJson = Objects.requireNonNull(client.newCall(request).execute().body()).string();
        log.info("resp json: {}", respJson);
        return JSON.parseObject(respJson, RpcfxResponse.class);
    }
}
