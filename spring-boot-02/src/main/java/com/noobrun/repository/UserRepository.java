package com.noobrun.repository;

import com.noobrun.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2017/3/14.
 */
public interface UserRepository extends JpaRepository<User,String> {
    User findUserByName(String name);
}