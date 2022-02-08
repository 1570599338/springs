package com.lquan.controller;

import com.lquan.domain.UserOnline;
import com.lquan.service.UserOnlineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 在线用户记录(UserOnline)表控制层
 *
 * @author makejava
 * @since 2022-02-09 00:02:54
 */
@RestController
@RequestMapping("userOnline")
public class UserOnlineController {
    /**
     * 服务对象
     */
    @Resource
    private UserOnlineService userOnlineService;

    /**
     * 分页查询
     *
     * @param userOnline 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UserOnline>> queryByPage(UserOnline userOnline, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userOnlineService.queryByPage(userOnline, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserOnline> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userOnlineService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userOnline 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserOnline> add(UserOnline userOnline) {
        return ResponseEntity.ok(this.userOnlineService.insert(userOnline));
    }

    /**
     * 编辑数据
     *
     * @param userOnline 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserOnline> edit(UserOnline userOnline) {
        return ResponseEntity.ok(this.userOnlineService.update(userOnline));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userOnlineService.deleteById(id));
    }

}

