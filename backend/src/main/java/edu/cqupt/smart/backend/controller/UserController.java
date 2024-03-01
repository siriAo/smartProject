package edu.cqupt.smart.backend.controller;

import edu.cqupt.smart.backend.entity.User;
import edu.cqupt.smart.backend.service.UserService;
import edu.cqupt.smart.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package_Name: edu.cqupt.smart.backend.controller
 * @Description: TODO
 * @Date: 2024/2/22 14:35
 * @Created: SiriAo
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.check(user);
    }

    @GetMapping("/{userId}")
    public Result User(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping()
    public Result addUser(@RequestParam("nickName") String nickName,
                          @RequestParam("userName") String userName,
                          @RequestParam("password") String password) {
        return userService.addUser(new User(nickName, userName, password));
    }
}
