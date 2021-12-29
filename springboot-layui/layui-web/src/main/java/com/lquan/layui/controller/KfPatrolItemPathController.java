package com.lquan.layui.controller;

import com.kaishun.study.entity.KfPatrolItemPath;
import com.kaishun.study.service.KfPatrolItemPathService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 检查项父子深度表(KfPatrolItemPath)表控制层
 *
 * @author easycode
 * @since 2021-12-09 09:56:14
 */
@RestController
@RequestMapping("kfPatrolItemPath")
public class KfPatrolItemPathController {
    /**
     * 服务对象
     */
    @Resource
    private KfPatrolItemPathService kfPatrolItemPathService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public KfPatrolItemPath selectOne(Integer id) {
        return this.kfPatrolItemPathService.queryById(id);
    }

}
