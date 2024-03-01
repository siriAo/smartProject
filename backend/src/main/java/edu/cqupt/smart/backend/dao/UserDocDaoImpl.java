package edu.cqupt.smart.backend.dao;

import edu.cqupt.smart.backend.dao.inter.UserDocDao;
import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.util.MongoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public UserDoc submit(UserDoc userDoc) {
        userDoc.setId(mongoUtil.getDocCount());
        mongoUtil.selfIncrease();
        return mongoOp.insert(userDoc);
    }

    @Override
    public UserDoc update(UserDoc userDoc) {
        return mongoOp.save(userDoc);
    }

    @Override
    public UserDoc queryByDocId(Long docId) {
        try {
            Optional<UserDoc> result = mongoOp.query(UserDoc.class)
                    .matching(query(where("id").is(docId)))
                    .one();
            if (result.isEmpty()) return null;
            return result.get();
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        } finally {
            return null;
        }
    }

    @Override
    public List<UserDoc> queryByUserId(Long userId) {
        return mongoOp.query(UserDoc.class)
                .matching(query(where("userId").is(userId)))
                .all();
    }
}
