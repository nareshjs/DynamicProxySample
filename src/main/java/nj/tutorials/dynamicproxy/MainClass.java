package nj.tutorials.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import nj.tutorials.dynamicproxy.proxyhandler.MyCglibMethodInterceptor;
import nj.tutorials.dynamicproxy.proxyhandler.MyInvocationHandler;
import nj.tutorials.dynamicproxy.support.MyImplWithoutInterface;
import nj.tutorials.dynamicproxy.support.MyImplementation;

import java.lang.reflect.Proxy;

public class MainClass {
    public static void main(String[] args)
    {
        //Using Java Proxy mechanism if you want to proxy a class which implements an interface
        MyInterface instance = new MyImplementation();
        MyInvocationHandler handler = new MyInvocationHandler(instance);
        MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
                new Class[] {MyInterface.class}, handler);
        proxyInstance.helloWorld("From Proxy Instance created using Interface!");

        //Use CGLIB if you want to proxy a class which does not implement an interface
        MyImplWithoutInterface implInstance = new MyImplWithoutInterface();
        MyCglibMethodInterceptor implHandler = new MyCglibMethodInterceptor(implInstance);
        MyImplWithoutInterface implProxyInstance = (MyImplWithoutInterface) Enhancer.create(MyImplWithoutInterface.class, implHandler);;
        implProxyInstance.helloWorld("From Proxy Instance created using Implementation!");
    }
}
