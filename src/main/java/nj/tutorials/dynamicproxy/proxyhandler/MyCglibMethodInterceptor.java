package nj.tutorials.dynamicproxy.proxyhandler;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import nj.tutorials.dynamicproxy.support.MyImplWithoutInterface;

import java.lang.reflect.Method;

public class MyCglibMethodInterceptor implements MethodInterceptor {
    private MyImplWithoutInterface myImplementation;

    public MyCglibMethodInterceptor(MyImplWithoutInterface reference)
    {
        myImplementation = reference;
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("BEFORE Using CGLIB");
        Object retVal = method.invoke(myImplementation, args);
        System.out.println("AFTER Using CGLIB");
        return retVal;
    }
}
