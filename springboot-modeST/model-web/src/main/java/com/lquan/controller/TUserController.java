package com.lquan.controller;

import com.lquan.domain.TUser;
import com.lquan.service.TUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息表(TUser)表控制层
 *
 * @author lquan
 * @since 2022-03-07 21:38:05
 */
@RestController
@RequestMapping("tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TUser> add(TUser tUser) {
        return ResponseEntity.ok(this.tUserService.insert(tUser));
    }

    /**
     * 编辑数据
     *
     * @param tUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TUser> edit(TUser tUser) {
        return ResponseEntity.ok(this.tUserService.update(tUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tUserService.deleteById(id));
    }

}

