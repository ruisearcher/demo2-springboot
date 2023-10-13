package com.example.demo2.config.threadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.*;
/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/13 15:41
 * @version 1.0
 * @Description 线程池工厂
 */
@Configuration
public class ThreadPoolFactory {

    @Resource
    private ThreadPoolConfig threadPoolConfig;

    @Bean("threadPool")
    public ThreadPoolExecutor createPool(){
        return new ThreadPoolExecutor(
                threadPoolConfig.getCorePoolSize(),
                threadPoolConfig.getMaximumPoolSize(),
                threadPoolConfig.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(threadPoolConfig.getWorkQueueSize()),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}

