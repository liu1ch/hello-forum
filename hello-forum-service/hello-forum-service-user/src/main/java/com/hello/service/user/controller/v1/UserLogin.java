package com.hello.service.user.controller.v1;

import com.hello.service.user.service.UserService;
import com.hello.model.user.vos.UserLoginVO;
import com.hello.model.user.dtos.LoginDTO;
import com.hello.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserLogin {
    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public Result check(){
        return Result.success();
    }
    @PostMapping ("/login")
    public Result<UserLoginVO> login(@ModelAttribute LoginDTO loginDTO) throws PasswordException {
        log.info("{}",loginDTO);
        UserLoginVO userVO = userService.login(loginDTO);
        return Result.success(userVO);
    }
    @PostMapping ("/register")
    public Result<UserLoginVO> register(@ModelAttribute LoginDTO loginDTO) throws PasswordException {
        log.info("{}",loginDTO);
        UserLoginVO userVO = userService.login(loginDTO);
        return Result.success(userVO);
    }

}
