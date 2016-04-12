package service;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

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

    @Autowired
    private LogService logService;

    @Autowired
    private Environment env;

    @Value("${appName}")
    private String appName;

    private String serviceName;

    @Override
    public void setBeanName(String name) {
        echoService.echo("I'm " + name);
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String hello(String name){
        System.out.println("current app: " + appName);
        System.out.println("current active profile: " + env.getActiveProfiles()[0]);
        System.out.println("current service: " + serviceName);

        echoService.echo(name);
        logService.info("log: hello " + name);
        return "hello, " + name;
    }
}
