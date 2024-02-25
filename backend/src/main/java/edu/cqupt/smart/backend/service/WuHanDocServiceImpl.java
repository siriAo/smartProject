package edu.cqupt.smart.backend.service;

import edu.cqupt.smart.backend.dao.WuHanDocDaoImpl;
import edu.cqupt.smart.backend.service.inter.WuHanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package_Name: edu.cqupt.smart.backend.service
 * @Description: TODO
 * @Date: 2024/2/21 4:19
 * @Created: SiriAo
 */
@Service
public class WuHanDocServiceImpl implements WuHanDocService {
    @Autowired
    private WuHanDocDaoImpl wuHanDocDaoImpl;

}
