package com.lquan.layui.controller;

import com.lquan.layui.domain.Queoption;
import com.lquan.layui.service.QueoptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Queoption)表控制层
 *
 * @author makejava
 * @since 2022-01-05 23:55:50
 */
@RestController
@RequestMapping("queoption")
public class QueoptionController {
    /**
     * 服务对象
     */
    @Resource
    private QueoptionService queoptionService;

    /**
     * 分页查询
     *
     * @param queoption 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Queoption>> queryByPage(Queoption queoption, PageRequest pageRequest) {
        return ResponseEntity.ok(this.queoptionService.queryByPage(queoption, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Queoption> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.queoptionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param queoption 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Queoption> add(Queoption queoption) {
        return ResponseEntity.ok(this.queoptionService.insert(queoption));
    }

    /**
     * 编辑数据
     *
     * @param queoption 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Queoption> edit(Queoption queoption) {
        return ResponseEntity.ok(this.queoptionService.update(queoption));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.queoptionService.deleteById(id));
    }

}

