package edu.cqupt.smart.backend.service.inter;

import edu.cqupt.smart.backend.entity.UserDoc;

import java.util.List;

/**
 * @Package_Name: edu.cqupt.smart.backend.service
 * @Description: TODO
 * @Date: 2024/2/19 18:04
 * @Created: SiriAo
 */
public interface UserDocService {
    /**
     * 提交新的用户文档
     *
     * @param userDoc
     * @return
     */
    public Boolean submit(UserDoc userDoc);

    /**
     * 更新特定文档
     *
     * @param userDoc
     * @return
     */
    public Boolean update(UserDoc userDoc);

    /**
     * 查询用户的所有文档
     *
     * @param userId
     * @return
     */
    public List<UserDoc> queryByUserId(Long userId);

}
