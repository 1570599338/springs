package com.lquan.controller;

import com.lquan.bean.Resp.Ztree;
import com.lquan.domain.Dept;
import com.lquan.domain.Role;
import com.lquan.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表(Dept)表控制层
 *
 * @author makejava
 * @since 2022-02-09 23:26:22
 */
@Controller
@RequestMapping("/system/dept")
public class DeptController {

    private String prefix = "system/dept";

    @Autowired
    private DeptService deptService;

    @RequiresPermissions("system:dept:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/dept";
    }

    @RequiresPermissions("system:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public List<Dept> list(Dept dept)
    {
        List<Dept> deptList = deptService.selectDeptList(dept);
        return deptList;
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = deptService.selectDeptTree(new Dept());
        return ztrees;
    }


    /**
     * 加载角色部门（数据权限）列表树
     */
    @GetMapping("/roleDeptTreeData")
    @ResponseBody
    public List<Ztree> deptTreeData(Role role)
    {
        List<Ztree> ztrees = deptService.roleDeptTreeData(role);
        return ztrees;
    }

}

