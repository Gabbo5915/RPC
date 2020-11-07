package com.pengge.dispather;

import com.pengge.dto.RPCCommonReqDTO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceDispatcher {
    public static Object dispatch(Object object){
        // using reflection to refer to different function.
        // classpath
        // function name
        // class instance by class.newInstance
        // arguments for function
        RPCCommonReqDTO rpcCommonReqDTO = (RPCCommonReqDTO)object;
        String methodName = rpcCommonReqDTO.getMethodName();
        String classPath = rpcCommonReqDTO.getClassPath();
        Object[] args = rpcCommonReqDTO.getArgs();
        Class[] types = null;
        Object resObject = null;
        if(args != null && args.length > 0) {
            types = new Class[args.length];
            for (int i = 0; i < types.length; i++) {
                types[i] = args[i].getClass();
            }
        }
        //
        try {
            Class<?> aClass = Class.forName(classPath);
            Method method = aClass.getDeclaredMethod(methodName, types);
            resObject = method.invoke(aClass.newInstance(), args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return resObject;
    }
}
