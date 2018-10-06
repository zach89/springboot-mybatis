package com.sf.zachweb.exception;
import com.sf.zachweb.utils.Res;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    public Res defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("",e);
        Res res = Res.buildFail("系统错误");
        res.setDetail(e.getMessage());
        return res;
    }
}
