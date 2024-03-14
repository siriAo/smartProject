package edu.cqupt.smart.backend.controller;

import edu.cqupt.smart.backend.entity.po.User;
import edu.cqupt.smart.backend.service.UserService;
import edu.cqupt.smart.backend.entity.vo.Result;
import jakarta.annotation.Resource;
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
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.check(user);
    }

    @GetMapping("/{userId}")
    public Result User(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping()
    public Result updateUser(@RequestParam("userId") Long userId,
                             @RequestParam("nickName") String nickName,
                             @RequestParam("userName") String userName,
                             @RequestParam("password") String password){
        return userService.updateUser(new User(userId,nickName, userName, password));
    }

    @PostMapping()
    public Result addUser(@RequestParam("nickName") String nickName,
                          @RequestParam("userName") String userName,
                          @RequestParam("password") String password) {
        return userService.addUser(new User(nickName, userName, password));
    }
}
