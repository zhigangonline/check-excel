package com.use.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ProjectPathUtil {

    public static String getApplicationPath() {
        String applicationPath = "";
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = SpringContextHolder.getBean(TomcatServletWebServerFactory.class);
            Environment env = SpringContextHolder.getApplicationContext().getEnvironment();
            ResourceBundle bundle = new PropertyResourceBundle(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            String envPort = env.getProperty("server.port");
            String propertyPort = bundle.getString("server.port");
            applicationPath = "http://" + host + ":" +("-1".equals(envPort) ? propertyPort:envPort) + contextPath + "/";
            System.out.println(applicationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return applicationPath;
    }

}
