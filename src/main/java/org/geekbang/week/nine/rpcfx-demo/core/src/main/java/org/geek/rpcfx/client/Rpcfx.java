package org.geekbang.week.nine.rpcfx;

import com.alibaba.fastjson.parser.ParserConfig;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author lil
 */
public class Rpcfx {

    static {
        ParserConfig.getGlobalInstance().addAccept("org.geek.rpcfx");
    }

    public static <T> T create(final Class<T> serviceClass, final String url) {
        // 0. 替换动态代理 -> 字节码生成
        return (T) Proxy.newProxyInstance(Rpcfx.class.getClassLoader(), new Class[]{serviceClass}, new RpcfxInvocationHandler(serviceClass, url));
    }
}
