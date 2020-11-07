package com.pengge.proxy;

import com.pengge.api.UserService;

import java.lang.reflect.Proxy;

public class FactoryProxy {

    public static <T> T getInstanceByClassType(Class<T> interfaceClazz){
        return (T) Proxy.newProxyInstance(FactoryProxy.class.getClassLoader(),
                new Class[]{interfaceClazz},
                new RPCInvocationHandler());
    }
}
