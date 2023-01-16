package com.lquan.controller;

import com.lquan.domain.Storage;
import com.lquan.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Storage)表控制层
 *
 * @author makejava
 * @since 2023-01-17 02:53:11
 */
@RestController
@RequestMapping("storage")
public class StorageController {
    /**
     * 服务对象
     */
    @Resource
    private StorageService storageService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Storage> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.storageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param storage 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Storage> add(Storage storage) {
        return ResponseEntity.ok(this.storageService.insert(storage));
    }

    /**
     * 编辑数据
     *
     * @param storage 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Storage> edit(Storage storage) {
        return ResponseEntity.ok(this.storageService.update(storage));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.storageService.deleteById(id));
    }

}

