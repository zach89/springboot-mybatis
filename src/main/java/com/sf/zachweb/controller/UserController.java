package com.sf.zachweb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sf.zachweb.model.User;
import com.sf.zachweb.services.UserService;
import com.sf.zachweb.utils.Res;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(value = "UserController", description = "用户相关api")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "list", notes = "获取用户列表")
    @RequestMapping(value = "/lists",method = RequestMethod.GET)
    public Res<PageInfo<User>> lists(@RequestParam(value = "currentPage") Integer currentPage,@RequestParam(value = "pageSize") Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<User> list = userService.lists();
        PageInfo<User> records = new PageInfo<>(list);
        return Res.buildOk(records);
    }
    @ApiOperation(value = "获取单个用户", notes = "通过id")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name="id", value = "用户id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Res<User> get(@PathVariable("id") Integer id){
        User user = userService.queryById(id);
        return Res.buildOk(user);
    }
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Res<User> create(@RequestBody User user){
        userService.create(user);
        return Res.buildOk("创建成功");
    }

    @ApiOperation(value = "修改用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name="id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name="user", value = "用户详细实体user", required = true, dataType = "User"),
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Res update(@RequestBody User user,@PathVariable("id") Integer id){
        Assert.notNull(id,"用户ID不能为空");
        userService.update(user);
        return Res.buildOk("修改成功");
    }
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name="id", value = "用户id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Res remove(@PathVariable("id") Integer id){
        userService.remove(id);
        return Res.buildOk("创建成功");
    }
}
