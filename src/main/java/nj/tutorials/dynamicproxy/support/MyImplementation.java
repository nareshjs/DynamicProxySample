package nj.tutorials.dynamicproxy.support;

import nj.tutorials.dynamicproxy.MyInterface;

public class MyImplementation implements MyInterface {

    @Override
    public String helloWorld(String welcomeMessage) {
        System.out.println("Hello Dynamic Proxy World! " + welcomeMessage);
        return "Hi";
    }
}
