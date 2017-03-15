package com.noobrun.controller;

import com.noobrun.domain.Result;
import com.noobrun.domain.User;
import com.noobrun.exception.MyException;
import com.noobrun.properties.UserProperties;
import com.noobrun.service.UserService;
import com.noobrun.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by lenovo on 2017/3/14.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserProperties userProperties;

    @RequestMapping("/hello")
    public Object sayHello() {
        return "hello:"+userProperties.toString();
    }

    /**
     * 查询用户列表信息
     * @return
     */
    @GetMapping("/users")
    public Result userList(){
        return ResultUtil.success(userService.findAll());
    }

    /**
     * 通过名称查询用户信息
     * @return
     */
    @GetMapping("/user/name/{name}")
    public Result findUserByName(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyException(201,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(userService.findUserByName(user.getName()));
    }

    /**
     * 新增用户信息
     * @return
     */
    @PostMapping("/user")
    public Result addUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyException(201,bindingResult.getFieldError().getDefaultMessage());
        }
        userService.save(user);
        return ResultUtil.success();
    }

    /**
     * 查询单个用户详情
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Result findUser(@PathVariable String id){
        User user=userService.findUser(id);
        return ResultUtil.success(user);
    }

    /**
     * 删除单个员工
     * @param id
     */
    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResultUtil.success();
    }

    @PutMapping("/user")
    public  Result updateUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new MyException(201,bindingResult.getFieldError().getDefaultMessage());
        }
        userService.updateUser(user);
        return ResultUtil.success();
    }

}
