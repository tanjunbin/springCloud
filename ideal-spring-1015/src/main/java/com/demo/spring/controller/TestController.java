package com.demo.spring.controller;

import com.demo.spring.dto.Result;
import com.demo.spring.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@Slf4j
@Api("spring_learn学习接口")
@RestController
@RequestMapping(value = "/spring")
public class TestController {

    @ApiOperation(value = "测试接口",notes = "测试接口")
    @PostMapping("/test")
    Result test(){
        return Result.ok("success");
    }


}
