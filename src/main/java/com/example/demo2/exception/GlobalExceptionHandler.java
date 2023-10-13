package com.example.demo2.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/6/7 9:34
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    // 打印log
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    // ……
    /**
     * 缺少请求参数异常
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public <T> JsonResult<T> handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return new JsonResult<T>(400, "缺少必要的请求参数");
    }

    /**
     * 运行时异常
     *
     * @param ex RuntimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
    public JsonResult handleRunTimeException(RuntimeException ex) {
        logger.error("运行异常", ex);
        return new JsonResult(HttpStatus.NOT_IMPLEMENTED.value(), ex.getMessage());
    }
}
