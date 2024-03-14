package edu.cqupt.smart.backend.service.inter;

import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.entity.vo.Result;

/**
 * @Package_Name: edu.cqupt.smart.backend.service
 * @Description: TODO
 * @Date: 2024/2/19 18:04
 * @Created: SiriAo
 */
public interface UserDocService {
    /**
     * 提交新的没有docId的用户文档
     *
     * @param userDoc
     * @return
     */
    public Result submit(UserDoc userDoc);

    /**
     * 更新
     *
     * @param userDoc
     * @return
     */
    public Result update(UserDoc userDoc);

    /**
     *
     * @param docId
     * @return
     */
    public Result queryByDocId(Long docId);

    /**
     * 查询用户的所有文档
     *
     * @param userId
     * @return
     */
    public Result queryByUserId(Long userId);
}
