package com.hinton.staging.test.adapter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "测试信息，客户端返回")
@Data
public class OutTest {
    @ApiModelProperty(value = "测试名称" ,required = true,example = "kg/m/...")
    @Size(min = 1, message = "",max = 10)
    @NotNull(message = "")
    private String name = "";
}
