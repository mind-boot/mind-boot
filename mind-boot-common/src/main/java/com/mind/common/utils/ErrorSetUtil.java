package com.mind.common.utils;

import com.mind.common.base.ResultBase;
import com.mind.common.enums.MindBootEnum;
import com.mind.common.exception.BaseBizException;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019-01-21 20:29
 **/
public class ErrorSetUtil {
    /**
     * 设置查询错误消息
     *
     * @param result 结果基类
     * @param e      异常
     */
    public static <T> void setQueryErrorMsg(ResultBase<T> result, Exception e) {
        result.setErrorCode(MindBootEnum.QUERY_ERROR.getCode());
        result.setErrorMsg(MindBootEnum.QUERY_ERROR.getMsg());
        if (e instanceof BaseBizException) {
            BaseBizException biz = (BaseBizException) e;
            result.setErrorCode(biz.getErrorCode());
            result.setErrorMsg(biz.getMessage());
        }
    }

}
