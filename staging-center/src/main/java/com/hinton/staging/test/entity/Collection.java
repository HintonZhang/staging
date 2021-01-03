package com.hinton.staging.test.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zhangzhenkang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Collection {


    @NotNull
    private Long collectionId = 0L;

    @NotNull
    private String referenceType = "";

    @NotNull
    private Long userId = 0L;

    @NotNull
    private Long referenceId = 0L;

    @NotNull
    private int isDeleted = 0;

    @NotNull
    private Long projectId = 0L;

    @NotNull
    private Long enterpriseId = 0L;

    @Column(updatable = false)
    private Long created = 0L;

    @Column(insertable = false, updatable = false)
    private Date lastmod;
}
