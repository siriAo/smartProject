package edu.cqupt.smart.backend.service;

import edu.cqupt.smart.backend.dao.inter.UserDocDao;
import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.service.inter.UserDocService;
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
    public Boolean submit(UserDoc userDoc) {
        return userDocDao.submit(userDoc);
    }

    @Override
    public Boolean update(UserDoc userDoc) {
        return userDocDao.update(userDoc);
    }

    @Override
    public List<UserDoc> queryByUserId(Long userId) {
        return userDocDao.queryByUserId(userId);
    }
}
