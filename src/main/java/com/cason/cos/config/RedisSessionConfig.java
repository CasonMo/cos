package com.cason.cos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/20
 * Time: 1:10
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class RedisSessionConfig {
}