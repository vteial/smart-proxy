package com.ahaitech.icreader;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SmileyHttpProxyServletConfig implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        System.out.println("---------------------------------------------------------");
//        String propValue = this.environment.getProperty("proxy.icreader.servlet_url");
//        System.out.println("proxy.icreader.servlet_url : " + propValue);
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), propValue);
//        propValue = this.environment.getProperty("proxy.icreader.target_uri");
//        System.out.println("proxy.icreader.target_url : " + propValue);
//        servletRegistrationBean.addInitParameter("targetUri", propValue);
//        propValue = this.environment.getProperty("proxy.icreader.logging_enabled", "false");
//        System.out.println("proxy.icreader.logging_enabled : " + propValue);
//        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propValue);
//        System.out.println("---------------------------------------------------------");
//        return servletRegistrationBean;
//    }

}
