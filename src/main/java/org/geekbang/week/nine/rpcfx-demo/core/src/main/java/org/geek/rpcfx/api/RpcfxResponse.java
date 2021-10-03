package org.geek.rpcfx.api;

import lombok.Data;

/**
 * 描述:
 *
 * @author lil
 */
@Data
public class RpcfxResponse {
    private Object result;
    private boolean status;
    private Exception exception;
}
