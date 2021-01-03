package com.hinton.staging.test.adapter;

import com.hinton.staging.test.entity.Collection;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hinton
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutCollection {

    @ApiModelProperty(value = "收藏夹id" ,required = true)
    @NotNull(message = "")
    private Long collectionId = 0L;

    @ApiModelProperty(value = "表名" ,required = true)
    @NotNull(message = "")
    private String referenceType = "";

    @ApiModelProperty(value = "用户id" ,required = true)
    @NotNull(message = "")
    private Long userId = 0L;

    @ApiModelProperty(value = "外键id" ,required = true)
    @NotNull(message = "")
    private Long referenceId = 0L;

    @ApiModelProperty(value = "删除标记" ,required = true)
    @NotNull(message = "")
    private int isDeleted = 0;

    @ApiModelProperty(value = "项目id" ,required = true)
    @NotNull(message = "")
    private Long projectId = 0L;

    @ApiModelProperty(value = "企业id" ,required = true)
    @NotNull(message = "")
    private Long enterpriseId = 0L;

    @ApiModelProperty(value = "创建日期" ,required = true)
    @NotNull(message = "")
    private Long created = 0L;

    @ApiModelProperty(value = "更新日期" ,required = true)
    @NotNull(message = "")
    private Date lastmod;


    public OutCollection(Collection collection){
        this.setUserId(collection.getUserId());
        this.setCollectionId(collection.getCollectionId());
        this.setIsDeleted(collection.getIsDeleted());
        this.setCreated(collection.getCreated());
        this.setLastmod(collection.getLastmod());
        this.setReferenceId(collection.getReferenceId());
        this.setReferenceType(collection.getReferenceType());
        this.setProjectId(collection.getProjectId());
        this.setEnterpriseId(collection.getEnterpriseId());
    }
}
