package com.aiwhale.tool;

/**
 * @author wendong
 * @email wendong@aiwhale.com
 * @date 2017/9/11.
 */
public enum Code {

    SUCCESS(10200, "成功"),
    INTERNAL_SERVER_ERROR(50500, "系统异常");

    public String note;
    public Integer code;

    Code(Integer code, String note) {
        this.note = note;
        this.code = code;
    }

}
