package edu.cqupt.smart.backend.dao;

import edu.cqupt.smart.backend.entity.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package_Name: edu.cqupt.smart.backend.dao
 * @Description: TODO
 * @Date: 2024/2/22 13:28
 * @Created: SiriAo
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);
}
