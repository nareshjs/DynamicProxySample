package nj.tutorials.dynamicproxy.support;

public class MyImplWithoutInterface {
    public String helloWorld(String welcomeMessage) {
        System.out.println("Hello CGLIB Proxy World! " + welcomeMessage);
        return "Bye";
    }
}
