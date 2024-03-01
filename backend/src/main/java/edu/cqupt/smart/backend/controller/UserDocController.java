package edu.cqupt.smart.backend.controller;

import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.service.inter.UserDocService;
import edu.cqupt.smart.backend.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package_Name: edu.cqupt.smart.backend.controller
 * @Description: TODO
 * @Date: 2024/2/19 18:01
 * @Created: SiriAo
 */
@RestController
@RequestMapping("/doc/user")
public class UserDocController {
    @Autowired
    private UserDocService userDocService;

    @PostMapping("/{userId}")
    public Result submit(
            @PathVariable("userId") Long userId, //  匿名用户userId为0
            @RequestParam("title") String title,
            @RequestParam("content") String content) {
        //校验用户是否存在 可从token中获取
        return userDocService.submit(new UserDoc(userId, title, content));
    }


    @PutMapping("/{userId}/{docId}")
    public Result update(
            @PathVariable("userId") Long userId,
            @PathVariable("docId") Long docId,
            @RequestParam("title") String title,
            @RequestParam("content") String content) {
        return userDocService.update(new UserDoc(docId, userId, title, content));
    }

    @GetMapping("/{userId}")
    public Result queryDocByUserId(@PathVariable("userId") Long userId) {
        return userDocService.queryByUserId(userId);
    }

}
