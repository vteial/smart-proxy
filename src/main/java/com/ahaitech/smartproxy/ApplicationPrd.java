package com.ahaitech.smartproxy;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!dev")
public class ApplicationPrd {

}
