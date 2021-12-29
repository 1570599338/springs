package com.lquan.layui.controller;

import com.kaishun.study.entity.KfPatrolItemInfo;
import com.kaishun.study.service.KfPatrolItemInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 巡查检查项信息(KfPatrolItemInfo)表控制层
 *
 * @author easycode
 * @since 2021-12-08 18:06:57
 */
@RestController
@RequestMapping("kfPatrolItemInfo")
public class KfPatrolItemInfoController {
    /**
     * 服务对象
     */
    @Resource
    private KfPatrolItemInfoService kfPatrolItemInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public KfPatrolItemInfo selectOne(Integer id) {
        return this.kfPatrolItemInfoService.queryById(id);
    }

}
