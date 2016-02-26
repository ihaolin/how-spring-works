package service;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 18/2/16
 */
public class HelloService implements BeanNameAware {

    private EchoService echoService;

    @Autowired
    private LogService logService;

    public void setEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    public String hello(String name){
        echoService.echo(name);
        logService.info("log: hello " + name);
        return "hello, " + name;
    }

    @Override
    public void setBeanName(String name) {
        echoService.echo("I'm " + name);
    }
}
