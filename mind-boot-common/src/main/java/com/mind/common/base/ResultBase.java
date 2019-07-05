package com.mind.common.base;

import com.mind.common.enums.MindBootEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 返回结果对象
 *
 * @param <T>
 * @author caoyong
 * @since 2018年1月29日 上午11:22:12
 */
@Getter
@Setter
@ToString
public class ResultBase<T> implements Serializable {
    private static final long serialVersionUID = 5060957039291207838L;

    //是否成功
    private boolean isSuccess = false;
    //错误消息
    private String errorMsg = "";
    //错误代码
    private String errorCode = "";
    //值
    private T value;

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        if (isSuccess) {
            this.errorMsg = MindBootEnum.SUCCESS.getMsg();
            this.errorCode = MindBootEnum.SUCCESS.getCode();
        }
    }
}
