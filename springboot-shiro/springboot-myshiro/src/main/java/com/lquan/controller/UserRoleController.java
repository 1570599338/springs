package com.lquan.controller;

import com.lquan.domain.UserRole;
import com.lquan.service.UserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户和角色关联表(UserRole)表控制层
 *
 * @author makejava
 * @since 2022-02-09 00:03:47
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 分页查询
     *
     * @param userRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UserRole>> queryByPage(UserRole userRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userRoleService.queryByPage(userRole, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userRole 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserRole> add(UserRole userRole) {
        return ResponseEntity.ok(this.userRoleService.insert(userRole));
    }

    /**
     * 编辑数据
     *
     * @param userRole 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserRole> edit(UserRole userRole) {
        return ResponseEntity.ok(this.userRoleService.update(userRole));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userRoleService.deleteById(id));
    }

}

