package com.use;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableJpaRepositories
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class CheckExcelApplication {

    private ApplicationContext ctx;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CheckExcelApplication.class, args);

        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            System.out.println("http://"+host+":"+port+contextPath+"/");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}