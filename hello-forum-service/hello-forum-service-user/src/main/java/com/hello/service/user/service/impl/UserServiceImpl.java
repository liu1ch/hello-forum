package com.hello.service.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.baomidu.mybatisplus.extension.service.impl.ServiceImpl;
import com.hello.common.constant.CommonConstants;
import com.hello.common.constant.JwtClaimsConstant;
import com.hello.common.constant.MessageConstant;
import com.hello.common.exception.AccountNotFoundException;
import com.hello.common.exception.AccountStatusException;
import com.hello.common.exception.PasswordErrorException;
import com.hello.common.utils.UserJwtUtil;
import com.hello.model.user.constants.AccountStatusConstants;
import com.hello.model.user.dtos.LoginDTO;
import com.hello.model.user.pojos.User;
import com.hello.service.user.service.UserService;
import com.hello.model.user.vos.UserLoginVO;
import com.hello.service.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
//import org.springframework.util.DigestUtils;
import java.util.HashMap;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 不多比比这就是登录
     * @param loginDTO
     * @return
     */
    @Override
    public UserLoginVO login(LoginDTO loginDTO)  {
        if(StringUtils.isNotBlank(loginDTO.getUsername())&&StringUtils.isNotBlank(loginDTO.getPassword())){
            User user = getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, loginDTO.getUsername()));
            if(user == null){
                throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
            }
            if(user.getStatus().equals(AccountStatusConstants.ACCOUNT_STATUS_DISABLE)){
                throw new AccountStatusException(MessageConstant.ACCOUNT_DISABLE);
            }
            String salt = user.getSalt();
            String password = loginDTO.getPassword();
//            String pswd = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if(!password.equals(user.getPassword())) {
                throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
            }

            String token = UserJwtUtil.getToken(user.getId().longValue());
            HashMap<String,Object> claims = new HashMap<>();
            claims.put(JwtClaimsConstant.USER_ID,user.getId());
            claims.put(JwtClaimsConstant.TOKEN,token);
            user.setSalt(CommonConstants.EMPTY_STRING);
            user.setPassword(CommonConstants.EMPTY_STRING);
            claims.put(JwtClaimsConstant.USER,user);

            UserLoginVO userLoginVO = UserLoginVO.builder()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .nickName(user.getNickName())
                    .token(token)
                    .build();
            return userLoginVO;
        }
        return null;
    }
}
