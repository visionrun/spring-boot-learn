package com.noobrun.service;

import com.noobrun.domain.User;
import com.noobrun.enums.ResultEnum;
import com.noobrun.exception.MyException;
import com.noobrun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/3/14.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) throws MyException {
        if(user.getAge()!=null && user.getAge()<18){
            throw new MyException(ResultEnum.USER_AGE_ERROR);
        }
        return userRepository.save(user);
    }

    public User findUser(String id) {
        return userRepository.findOne(id);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public User updateUser(User user) {
        System.out.println("Version="+user.getVersion());
        return userRepository.save(user);
    }
}
