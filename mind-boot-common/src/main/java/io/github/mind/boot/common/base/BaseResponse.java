package io.github.mind.boot.common.base;

import io.github.mind.boot.common.enums.MindBootEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 返回基类
 *
 * @author caoyong
 * @since 2018年1月29日 上午11:21:45
 */
@Getter
@Setter
@ToString
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 3230910710976511975L;
    /**
     * 定义的code
     */
    private String code = MindBootEnum.SUCCESS.getCode();
    /**
     * 消息
     */
    private String msg = MindBootEnum.SUCCESS.getMsg();

    /**
     * 是否成功
     */
    private boolean isSuccess = true;

    /**
     * 结果
     */
    private T data;

    public BaseResponse() {
    }
}