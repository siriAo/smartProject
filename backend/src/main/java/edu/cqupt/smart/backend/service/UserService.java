package edu.cqupt.smart.backend.service;

import edu.cqupt.smart.backend.config.security.handler.DBUserDetailsManager;
import edu.cqupt.smart.backend.dao.UserRepository;
import edu.cqupt.smart.backend.entity.po.User;
import edu.cqupt.smart.backend.entity.vo.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Package_Name: edu.cqupt.smart.backend.service
 * @Description: TODO
 * @Date: 2024/2/22 13:48
 * @Created: SiriAo
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    public Result check(User user) {
        System.out.println("用户登录" + user);
        // JWT校验
        return Result.ok().addData("token", "需要更改");
    }

    public Result getUserById(Long userId) {
        System.out.println("拉取userId={}用户数据".formatted(userId));
        Optional<User> r = userRepository.findById(userId);
        if (r.isEmpty()) return Result.error();
        User user = r.get();
        user.setPassword("null");
        return Result.ok().addData("user", user);
    }

    public Result updateUser(User user) {
        System.out.println("更新User" + user);
        User result = userRepository.save(user); // Hibernate已经在save()中根据主键实现了select和update（自动比较后更新）
        if (result.getUserid() == null) return Result.error();
        return Result.ok();
    }

    public Result addUser(User user) {
        System.out.println("添加用户" + user);
        User result = userRepository.save(user);
        if (result.getUserid() == null) return Result.error();
        return Result.ok();
    }
}
