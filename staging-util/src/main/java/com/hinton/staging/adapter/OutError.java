package com.hinton.staging.adapter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author hinton
 * @date 2017/3/17
 */
@ApiModel(description = "用来返回错误信息给前端的一个通用的数据结构")
@Setter
@Getter
public class OutError {
    public static final String ERROR_COMMON = "40000";

    /**
     * 未找到指定信息
     */
    public static final String ERROR_NOT_FOUND = "40011";
    /**
     * 操作失败
     */
    public static final String ERROR_OPERATION_FAILURE = "40012";
    /**
     * 操作无效
     */
    public static final String ERROR_INVALID = "40010";
    /**
     * 参数无效
     */
    public static final String ERROR_INVALID_PARAMTER = "40013";

    /**
     * 错误复制实例
     */
    public static final String ERROR_DUPLICATED_INSTANCE = "40016";

    /**
     * 参数冲突
     */
    public static final String ERROR_CONFLICT_PARAMETER = "40018";
    /**
     * 手机号冲突
     */
    public static final String ERROR_CONFLICT_MOBILE = "40015";
    /**
     * 发生错误，文件存在
     */
    public static final String ERROR_FILE_EXIST = "40019";
    /**
     * 文件不存在错误
     */
    public static final String ERROR_FILE_NOT_EXIST = "40020";

    /**
     * 没有权限
     */
    public static final String ERROR_NO_PERMISSION = "40017";

    /**
     * 未知错误
     */
    public static final String ERROR_UNKNOWN = "40999";

    @ApiModelProperty(value = "错误信息", required = true, example = "密码不正确")
    @NotNull
    @Size(min = 1)
    private String message = "";

    @ApiModelProperty(value = "错误码,可以根据错误查询到错误的简介", required = true, allowableValues = "40000,40010,40011,40012,40013,40015,40099", example = "40010")
    @NotNull
    private String code = "";

    @ApiModelProperty(value = "错误码,可以根据错误查询到错误的简介", required = true, allowableValues = "40000,40010,40011,40012,40013,40015,40099", example = "40010")
    @NotNull
    private String extra = "";

    public OutError() {
        this.message = "";
        this.code = "";
        this.extra = "";
    }

    public OutError(String message, String code, String extra) {
        this.message = message;
        this.code = code;
        this.extra = extra;
    }

    public OutError(String message, String code) {
        this.message = message;
        this.code = code;
        this.extra = "";
    }

    public OutError(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        this.message = sw.toString();
    }
}
