package com.lquan.controller;

import com.lquan.domain.RoleDept;
import com.lquan.service.RoleDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色和部门关联表(RoleDept)表控制层
 *
 * @author makejava
 * @since 2022-02-09 00:01:36
 */
@RestController
@RequestMapping("roleDept")
public class RoleDeptController {
    /**
     * 服务对象
     */
    @Resource
    private RoleDeptService roleDeptService;

    /**
     * 分页查询
     *
     * @param roleDept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RoleDept>> queryByPage(RoleDept roleDept, PageRequest pageRequest) {
        return ResponseEntity.ok(this.roleDeptService.queryByPage(roleDept, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RoleDept> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.roleDeptService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param roleDept 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RoleDept> add(RoleDept roleDept) {
        return ResponseEntity.ok(this.roleDeptService.insert(roleDept));
    }

    /**
     * 编辑数据
     *
     * @param roleDept 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RoleDept> edit(RoleDept roleDept) {
        return ResponseEntity.ok(this.roleDeptService.update(roleDept));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.roleDeptService.deleteById(id));
    }

}

