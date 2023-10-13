package com.example.demo2.aspect;

import com.example.demo2.annotation.CostTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/13 9:47
 */
@Aspect
@Component
public class CostTimeAspect {

    private static final Logger LOG = LogManager.getLogger(CostTimeAspect.class);

    @Around("@annotation(costTime)")
    public Object round(ProceedingJoinPoint joinPoint, CostTime costTime) {
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            LOG.error("{} 方法执行异常", joinPoint.getSignature().getName(), e);
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        LOG.info("{} 方法执行耗时：{}", joinPoint.getSignature().getName(), endTime - startTime);
        return result;
    }

}
