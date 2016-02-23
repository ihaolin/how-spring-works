package service;


import org.springframework.beans.factory.BeanNameAware;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 18/2/16
 */
public class HelloService implements BeanNameAware {

    private EchoService echoService;

    public void setEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    public String hello(String name){
        echoService.echo(name);
        return "hello, " + name;
    }

    @Override
    public void setBeanName(String name) {
        echoService.echo("I'm " + name);
    }
}
