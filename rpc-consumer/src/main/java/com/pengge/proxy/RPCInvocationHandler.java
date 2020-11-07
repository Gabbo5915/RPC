package com.pengge.proxy;

import com.pengge.api.UserService;
import com.pengge.dto.RPCCommonReqDTO;
import com.pengge.net.NetClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RPCInvocationHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCCommonReqDTO rpcCommonReqDTO = new RPCCommonReqDTO();
        rpcCommonReqDTO.setMethodName(method.getName());
        rpcCommonReqDTO.setArgs(args);
        rpcCommonReqDTO.setClassPath("com.pengge.api.imp.UserServiceImpl");

        // net invoke
        return NetClient.callRemoteService("localhost", 9999, rpcCommonReqDTO);
    }
}
