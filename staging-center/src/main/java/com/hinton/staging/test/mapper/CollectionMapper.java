package com.hinton.staging.test.mapper;


import com.hinton.staging.test.entity.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hinton
 */
@Repository
public interface CollectionMapper {
    /**
     * 新增用户标星
     * @param collection 新增收藏
     * @return 返回新增操作结果
     */
    int insertCollection(Collection collection);

    /**
     * 取消标星
     * @param userId 用户id
     * @param referenceId 引用id
     * @param referenceType 查询表
     * @return 删除操作结果
     */
    int deleteCollection(@Param("userId") Long userId,@Param("referenceId") Long referenceId,@Param("referenceType")String referenceType);

    /**
     * 取消标星
     *@param collectionId 收藏记录id
     * @return 删除操作结果
     */
    int deleteCollectionById(@Param("collectionId") Long collectionId);
    /**
     * 查询用户的标星记录
     * @param userId 用户id
     * @param referenceType 收藏表
     * @return 获取用户收藏列表
     */
    List<Collection> getUserCollection(@Param("userId")Long userId,@Param("referenceType")String referenceType);

    /**
     * 通过用户id和记录id及收藏类型查询标星记录
     * @param userId 用户id
     * @param referenceId 表主键id
     * @param referenceType 表名
     * @return 获取收藏记录
     */
    Collection getOneCollectionByUserAndReferenceId(@Param("userId")Long userId, @Param("referenceId") Long referenceId, @Param("referenceType")String referenceType);

    /**
     * 获取标星项目成员
     * @param userId 用户id
     * @param projectId 项目id
     * @return 获取用户成员收藏列表
     */
    List<Collection> getUserMemberCollection(@Param("userId")Long userId,@Param("projectId")Long projectId);

    /**
     * 获取标星企业员工
     * @param userId 用户id
     * @param enterpriseId 企业id
     * @return 获取员工收藏列表
     */
    List<Collection> getStaffCollection(@Param("userId")Long userId,@Param("enterpriseId")Long enterpriseId);
    /**
     * 删除项目，企业，项目成员时的需要执行此方法
     * @param referenceId 主键id
     * @param referenceType 引用类型
     * @return 统一删除记录
     */
    Integer deleteCollectionByReferenceIdAndReferenceType(@Param("referenceId") Long referenceId, @Param("referenceType")String referenceType);

    /**
     * 删除指定用户收藏的内容
     * @param userId 用户id
     * @param referenceId 主键id
     * @param referenceType 表名
     * @return 删除用户收藏夹的记录
     */
    Integer deleteUserCollectionByReferenceIdAndReferenceType(@Param("userId")Long userId,@Param("referenceId") Long referenceId, @Param("referenceType")String referenceType);
}
