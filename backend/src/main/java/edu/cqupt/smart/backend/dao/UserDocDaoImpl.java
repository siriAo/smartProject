package edu.cqupt.smart.backend.dao;

import edu.cqupt.smart.backend.dao.inter.UserDocDao;
import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.util.MongoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @Package_Name: edu.cqupt.smart.backend.dao
 * @Description: TODO
 * @Date: 2024/2/19 18:12
 * @Created: SiriAo
 */
@Repository
public class UserDocDaoImpl implements UserDocDao {
    @Autowired
    public MongoOperations mongoOp;
    @Autowired
    public MongoUtil mongoUtil;

    @Override
    public Boolean submit(UserDoc userDoc) {
        userDoc.setId(mongoUtil.getUserDocCount());
        mongoUtil.userDocSelfIncrease();

        System.out.println("Dao提交文档" + userDoc.toString());
        if (mongoOp.insert(userDoc) == null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(UserDoc userDoc) {
        System.out.println("Dao更新文档" + userDoc.toString());
        if (mongoOp.save(userDoc) == null) {
            return false;
        }
        return true;
    }

    @Override
    public UserDoc queryByDocId(Long docId) {
        UserDoc result = mongoOp.query(UserDoc.class)
                .matching(query(where("id").is(docId))).oneValue();
        System.out.println("查询docId=" + docId + "的文档" + result.toString());
        return result;
    }

    @Override
    public List<UserDoc> queryByUserId(Long userId) {
        List<UserDoc> result = mongoOp.query(UserDoc.class)
                .matching(query(where("userId").is(userId)))
                .all();
        System.out.println("Dao查询用户" + userId + "文档" + result.toString());
        return result;
    }
}
