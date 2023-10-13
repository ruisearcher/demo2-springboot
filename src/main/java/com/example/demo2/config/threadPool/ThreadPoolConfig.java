package com.example.demo2.config.threadPool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/13 15:39
 * @version 1.0
 * @Description 线程池配置类
 */
@Component
@Data
@ConfigurationProperties("thread.pool")
public class ThreadPoolConfig {

    private Integer corePoolSize = 3;

    private Integer maximumPoolSize = 6;

    private Integer keepAliveTime = 30;

    private Integer workQueueSize = 10000;

}

