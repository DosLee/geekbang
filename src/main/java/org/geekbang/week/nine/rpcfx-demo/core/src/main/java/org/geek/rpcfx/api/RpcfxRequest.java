package org.geek.rpcfx.api;

import lombok.Data;

/**
 * 描述:
 *
 * @author lil
 */
@Data
public class RpcfxRequest {
    private String serviceClass;
    private String method;
    private Object[] params;
}
