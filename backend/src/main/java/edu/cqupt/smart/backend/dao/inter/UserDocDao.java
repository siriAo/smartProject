package edu.cqupt.smart.backend.dao.inter;


import edu.cqupt.smart.backend.entity.UserDoc;

import java.util.List;

/**
 * @Package_Name: edu.cqupt.smart.backend.dao
 * @Description: TODO
 * @Date: 2024/2/19 18:12
 * @Created: SiriAo
 */
public interface UserDocDao {

    /**
     * 提交用户文档
     *
     * @param userDoc
     * @return
     */
    public UserDoc submit(UserDoc userDoc);

    /**
     * 更新用户文档
     *
     * @param userDoc
     * @return
     */
    public UserDoc update(UserDoc userDoc);

    /**
     * 查询docId文档
     * @param docId
     * @return
     */
    public UserDoc queryByDocId(Long docId);

    /**
     * 根据用户id查询所有文档
     *
     * @param userId
     * @return
     */
    public List<UserDoc> queryByUserId(Long userId);
}
