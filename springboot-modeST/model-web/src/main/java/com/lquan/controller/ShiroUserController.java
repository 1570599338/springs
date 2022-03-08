package com.lquan.controller;

import com.lquan.domain.ShiroUser;
import com.lquan.service.ShiroUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ShiroUser)表控制层
 *
 * @author lquan
 * @since 2022-03-08 17:29:23
 */
@RestController
@RequestMapping("shiroUser")
public class ShiroUserController {
    /**
     * 服务对象
     */
    @Resource
    private ShiroUserService shiroUserService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ShiroUser> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.shiroUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param shiroUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ShiroUser> add(ShiroUser shiroUser) {
        return ResponseEntity.ok(this.shiroUserService.insert(shiroUser));
    }

    /**
     * 编辑数据
     *
     * @param shiroUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ShiroUser> edit(ShiroUser shiroUser) {
        return ResponseEntity.ok(this.shiroUserService.update(shiroUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.shiroUserService.deleteById(id));
    }

}

