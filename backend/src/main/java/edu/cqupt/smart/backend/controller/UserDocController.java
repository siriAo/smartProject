package edu.cqupt.smart.backend.controller;

import edu.cqupt.smart.backend.entity.UserDoc;
import edu.cqupt.smart.backend.service.inter.UserDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String submit(
            @PathVariable("userId") Long userId,
            @RequestParam("title") String title, @RequestParam("content") String content) {
        System.out.println("Controller提交文档 " + "userId=" + userId + ' ' + title + ' ' + content);
//        匿名用户userId为0
        Boolean result = true;
        if (userId == 0L) {
            result = userDocService.submit(new UserDoc(Long.valueOf(0), title, content));
        } else {
            result = userDocService.submit(new UserDoc(userId, title, content));
        }
        if (!result) {
            return "提交失败";
        }
        return "提交成功";
    }


    @PutMapping("/{userId}/{docId}")
    public String update(
            @PathVariable("userId") Long userId, @PathVariable("docId") Long docId,
            @RequestParam("title") String title, @RequestParam("content") String content) {
        System.out.println("Controller更新文档 " + "userId=" + userId + ' ' + "docId=" + docId + ' ' + title + ' ' + content);

        Boolean result = userDocService.update(new UserDoc(docId, userId, title, content));
        if (!result) {
            return "更新失败";
        }
        return "更新成功";
    }

    @GetMapping("/{userId}")
    public List<UserDoc> queryDocByUserId(@PathVariable("userId") Long userId) {
        System.out.println("Controller查询用户文档" + "userId=" + userId);
        List<UserDoc> result = userDocService.queryByUserId(userId);
        return result;
    }


}
