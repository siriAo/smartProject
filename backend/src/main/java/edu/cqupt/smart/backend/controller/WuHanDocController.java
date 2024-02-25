package edu.cqupt.smart.backend.controller;

import edu.cqupt.smart.backend.service.WuHanDocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package_Name: edu.cqupt.smart.backend.controller
 * @Description: TODO
 * @Date: 2024/2/21 4:15
 * @Created: SiriAo
 */
@RestController
public class WuHanDocController {

    @Autowired
    private WuHanDocServiceImpl wuHanDocService;

    @GetMapping("/doc/wuhan/{queryCode}")
    public List query(@PathVariable("queryCode") String queryCode) {
        System.out.println(queryCode);
        return null;
    }
}
