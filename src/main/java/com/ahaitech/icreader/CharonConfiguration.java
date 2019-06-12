package com.ahaitech.icreader;

import com.github.mkopylec.charon.configuration.CharonConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static com.github.mkopylec.charon.configuration.CharonConfigurer.charonConfiguration;
import static com.github.mkopylec.charon.configuration.RequestMappingConfigurer.requestMapping;
import static com.github.mkopylec.charon.forwarding.interceptors.rewrite.RequestServerNameRewriterConfigurer.requestServerNameRewriter;

@Configuration
public class CharonConfiguration implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    CharonConfigurer charonConfigurer() {
        System.out.println("---------------------------------------------------------");
        String value1 = this.environment.getProperty("proxy.icreader.request_mapping");
        System.out.println("proxy.icreader.request_mapping : " + value1);
        String value2 = this.environment.getProperty("proxy.icreader.host_colon_port");
        System.out.println("proxy.icreader.host_colon_port : " + value2);
        System.out.println("---------------------------------------------------------");
        return charonConfiguration().set(requestServerNameRewriter().outgoingServers(value2)).add(requestMapping(value1));
    }

}