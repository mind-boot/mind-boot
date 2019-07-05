package com.mind.common.enums;

/**
 * 错误枚举
 *
 * @author caoyong
 * @since 2018年1月29日 上午11:34:26
 */
public enum MindBootEnum {
    PARAMETER_CAN_NOT_BE_NULL("1002", "参数不能为空"),

    SUCCESS("200", "成功"),
    QUERY_ERROR("301", "查询失败");


    private String code;
    private String msg;

    MindBootEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
