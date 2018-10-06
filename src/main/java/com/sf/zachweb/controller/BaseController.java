package com.sf.zachweb.controller;

import com.sf.zachweb.utils.Res;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(value = "BaseController", description = "基本测试")
public class BaseController {

    @ApiOperation(value = "hello world", notes = "hello world")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Res index() {
        return Res.buildOk("hello world!");
    }
}
