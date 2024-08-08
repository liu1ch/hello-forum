package com.hello.common.exception;



import com.hello.common.result.Result;
import com.hello.model.enums.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  //控制器增强类
@Slf4j
public class ExceptionCatch {

    /**
     * 处理不可控异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e){
        e.printStackTrace();
        log.error("catch exception:{}",e.getMessage());

        return Result.error(String.valueOf(AppHttpCodeEnum.SERVER_ERROR));
    }

    /**
     * 处理可控异常  自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result exception(CustomException e){
        log.error("catch exception:{}",e);
        return Result.error(e.getAppHttpCodeEnum());
    }
}
