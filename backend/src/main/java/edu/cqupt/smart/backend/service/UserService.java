package edu.cqupt.smart.backend.service;

import edu.cqupt.smart.backend.dao.UserRepository;
import edu.cqupt.smart.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package_Name: edu.cqupt.smart.backend.service
 * @Description: TODO
 * @Date: 2024/2/22 13:48
 * @Created: SiriAo
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId){
        System.out.println("拉取用户信息userId="+userId);
        User user= userRepository.findById(userId).get();
        user.setPassword("null");
        return user;
    }

    public Boolean addUser(User user) {
        System.out.println("添加用户" + user);
        User result = userRepository.save(user);
        if (result.getUserId()==null){
            return false;
        }
        return true;
    }
}
