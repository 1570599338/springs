package com.lquan.controller;

import com.lquan.domain.Post;
import com.lquan.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 岗位信息表(Post)表控制层
 *
 * @author makejava
 * @since 2022-02-09 00:00:53
 */
@RestController
@RequestMapping("post")
public class PostController {
    /**
     * 服务对象
     */
    @Resource
    private PostService postService;

    /**
     * 分页查询
     *
     * @param post 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Post>> queryByPage(Post post, PageRequest pageRequest) {
        return ResponseEntity.ok(this.postService.queryByPage(post, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Post> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.postService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param post 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Post> add(Post post) {
        return ResponseEntity.ok(this.postService.insert(post));
    }

    /**
     * 编辑数据
     *
     * @param post 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Post> edit(Post post) {
        return ResponseEntity.ok(this.postService.update(post));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.postService.deleteById(id));
    }

}

