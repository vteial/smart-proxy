package com.ahaitech.smartproxy.web.controllers;

import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.Arrays;

public abstract class AbstractController {

    @Resource
    Environment env;

    protected boolean isProfileIsActive(String profileId) {
        return Arrays.stream(env.getActiveProfiles()).anyMatch(profileId::equals);
    }

}
