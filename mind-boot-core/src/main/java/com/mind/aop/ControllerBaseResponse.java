package com.mind.aop;

import com.mind.common.base.BaseResponse;
import com.mind.common.base.ResultBase;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019-06-18 17:56
 **/
@Configuration
@ControllerAdvice
public class ControllerBaseResponse implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResultBase) {
            ResultBase result = (ResultBase) body;
            BaseResponse resp = new BaseResponse();
            resp.setCode(result.getErrorCode());
            resp.setMsg(result.getErrorMsg());
            resp.setData(result.getValue());
            resp.setSuccess(result.isSuccess());
            return resp;
        }
        return body;
    }
}
