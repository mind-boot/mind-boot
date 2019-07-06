package io.github.mind.boot.aop;

import io.github.mind.boot.common.base.BaseResponse;
import io.github.mind.boot.common.exception.BaseBizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author caoyong
 * @version 1.0.0
 * @since 2019-04-03 15:53
 **/
@Configuration
@ControllerAdvice
@Order(-1)
@Slf4j
public class GlobalExceptionHandler<T> {
    /**
     * 拦截业务异常
     */
	@ExceptionHandler(BaseBizException.class)
    @ResponseBody
    public BaseResponse<T> business(HttpServletRequest request, BaseBizException e) {
    	BaseResponse<T> result = new BaseResponse<>();
        String uri = request.getRequestURI();
        log.error(uri + " biz error:{}", e.getMessage(), e);
        result.setCode(e.getErrorCode());
        result.setMsg(e.getMessage());
        result.setSuccess(false);
        return result;
    }
}
