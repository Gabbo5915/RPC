package com.pengge.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * standard request model by RPC.
 */
@Data
public class RPCCommonReqDTO implements Serializable {
    private static final long serialVersionUID = -9023448818398667253L;
    private String methodName;
    private String classPath;
    private Object[] args;
}
