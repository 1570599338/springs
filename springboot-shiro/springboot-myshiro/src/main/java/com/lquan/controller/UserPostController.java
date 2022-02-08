package com.lquan.controller;

import com.lquan.domain.UserPost;
import com.lquan.service.UserPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户与岗位关联表(UserPost)表控制层
 *
 * @author makejava
 * @since 2022-02-09 00:03:17
 */
@RestController
@RequestMapping("userPost")
public class UserPostController {
    /**
     * 服务对象
     */
    @Resource
    private UserPostService userPostService;

    /**
     * 分页查询
     *
     * @param userPost 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UserPost>> queryByPage(UserPost userPost, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userPostService.queryByPage(userPost, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserPost> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userPostService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userPost 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserPost> add(UserPost userPost) {
        return ResponseEntity.ok(this.userPostService.insert(userPost));
    }

    /**
     * 编辑数据
     *
     * @param userPost 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserPost> edit(UserPost userPost) {
        return ResponseEntity.ok(this.userPostService.update(userPost));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userPostService.deleteById(id));
    }

}

