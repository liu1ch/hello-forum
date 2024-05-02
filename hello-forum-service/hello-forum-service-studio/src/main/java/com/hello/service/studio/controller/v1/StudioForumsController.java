package com.hello.service.studio.controller.v1;

import com.hello.common.result.Result;
import com.hello.model.studio.dtos.StudioForumsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@Slf4j
public class StudioForumsController {

    @GetMapping("/submit")
    public Result submitForums(){
        log.info("上传帖子");
        return Result.success();
    }
}
