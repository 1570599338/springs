package com.lquan.layui.controller;


import com.lquan.layui.domain.TbRole;
import com.lquan.layui.dto.resp.ResultVO;
import com.lquan.layui.service.TbRoleService;
import com.lquan.layui.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * (TbRole)表控制层
 *
 * @author makejava
 * @since 2020-02-25 12:47:33
 */
@RestController
@RequestMapping("tbRole")
@Slf4j
public class TbRoleController {
    /**
     * 服务对象
     */
    @Resource
    private TbRoleService tbRoleService;




    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbRole selectOne(String id) {
        return this.tbRoleService.queryById(id);
    }

    /**************************begin**************************/

    @GetMapping("/getList")
    public ResultVO getRoleList(){
        log.info("获取所有角色分页信息");
        List<TbRole> result = tbRoleService.getRoleList();
        return ResultVOUtil.success(result);
    }

    @DeleteMapping("/delete")
    public ResultVO deleteById(String id){
        log.info("删除 角色");
        tbRoleService.deleteById(id);
        return ResultVOUtil.success();
    }

    @PostMapping("/setRole")
    public ResultVO addRole(HttpServletRequest request, @Valid TbRole tbRole){
        log.info("添加角色信息");
        tbRoleService.insert(tbRole,request);
        return ResultVOUtil.success();
    }

    @PutMapping("/setRole")
    public ResultVO updateRole(HttpServletRequest request , TbRole tbRole){
        log.info("更新角色信息");
        tbRoleService.update(tbRole,request);
        return ResultVOUtil.success();
    }








}