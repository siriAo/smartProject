package edu.cqupt.smart.backend.service;

import edu.cqupt.smart.backend.dao.inter.UserDocDao;
import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.service.inter.UserDocService;
import edu.cqupt.smart.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package_Name: edu.cqupt.smart.backend.service
 * @Description: TODO
 * @Date: 2024/2/19 18:04
 * @Created: SiriAo
 */
@Service
public class UserDocServiceImpl implements UserDocService {
    @Autowired
    private UserDocDao userDocDao;

    @Override
    public Result submit(UserDoc userDoc) {
        System.out.println("提交UserDoc" + userDoc);
        userDocDao.submit(userDoc);
        return Result.ok();
    }

    @Override
    public Result update(UserDoc userDoc) {
        System.out.println("更新UserDoc" + userDoc);
        //查询该用户下是否存在该文档
        userDocDao.update(userDoc);
        return Result.ok();
    }

    @Override
    public Result queryByDocId(Long docId) {
        UserDoc doc = userDocDao.queryByDocId(docId);
        if (doc == null) return Result.empty();
        return Result.ok().addData("doc", doc);
    }

    @Override
    public Result queryByUserId(Long userId) {
        List list = userDocDao.queryByUserId(userId);
        if (list.isEmpty()) return Result.empty();
        return Result.ok().addData("docList", list);
    }
}
