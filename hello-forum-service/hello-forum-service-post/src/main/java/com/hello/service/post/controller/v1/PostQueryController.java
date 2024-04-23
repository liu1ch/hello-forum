package com.hello.service.post.controller.v1;


import com.hello.common.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostQueryController {
    /**
     * 加载首页
     * @param
     * @return
     */
    @PostMapping("/load")
    public Result load(){
        return Result.success();
    }
    @GetMapping("/get")
    public Result get(){
        return Result.success("ok");
    }
}
