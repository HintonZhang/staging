package com.hinton.staging.test.adapter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class InCollection {
    
    @ApiModelProperty(value = "收藏夹名称" ,required = true)
    @Size(min = 1, message = "",max = 10)
    @NotNull(message = "")
    private Long collectionId = 0L;


    @ApiModelProperty(value = "引用类型" ,required = true)
    @Size(min = 1, message = "",max = 10)
    @NotNull(message = "")
    private String referenceType = "";

    @ApiModelProperty(value = "用户id" ,required = true)
    @Size(min = 1, message = "",max = 10)
    @NotNull(message = "")
    private Long userId = 0L;

    @ApiModelProperty(value = "外键id" ,required = true)
    @Size(min = 1, message = "",max = 10)
    @NotNull(message = "")
    private Long referenceId = 0L;

    @ApiModelProperty(value = "项目id" ,required = true)
    @Size(min = 1, message = "",max = 10)
    @NotNull(message = "")
    private Long projectId = 0L;

    @ApiModelProperty(value = "企业id" ,required = true)
    @Max(value = 15,message = "")
    @NotNull(message = "")
    private Long enterpriseId = 0L;


}
