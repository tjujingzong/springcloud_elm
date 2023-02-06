package com.neusoft.controller;

import com.neusoft.po.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neusoft.po.User;
import com.neusoft.service.UserService;

@CrossOrigin("*") //跨域处理
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Login")
    public CommonResult<User> getUserByIdByPass(User user) throws Exception {
        return new CommonResult(200, "success", userService.getUserByIdByPass(user));
    }

    @GetMapping("/UserId")
    public CommonResult<Integer> getUserById(User user) throws Exception {
        int result = userService.getUserById(user.getUserId());
        return new CommonResult(200, "success", result);
    }

    @PostMapping("/UserId")
    public CommonResult<Integer> saveUser(User user) throws Exception {
        int result = userService.saveUser(user);
        return new CommonResult(200, "success", result);
    }
}