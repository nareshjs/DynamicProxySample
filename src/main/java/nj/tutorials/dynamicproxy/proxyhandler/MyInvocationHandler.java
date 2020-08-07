package nj.tutorials.dynamicproxy.proxyhandler;

import nj.tutorials.dynamicproxy.MyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private MyInterface instance;

    public MyInvocationHandler(MyInterface reference)
    {
        instance = reference;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("BEFORE");
        Object retValue = method.invoke(instance, args);
        System.out.println("AFTER");
        return retValue;
    }
}
