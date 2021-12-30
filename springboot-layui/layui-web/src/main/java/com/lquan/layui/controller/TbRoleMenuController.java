package com.lquan.layui.controller;

import com.lquan.layui.bean.req.RoleMenuInfo;
import com.lquan.layui.domain.TbRoleMenu;
import com.lquan.layui.dto.resp.ResultVO;
import com.lquan.layui.service.TbRoleMenuService;
import com.lquan.layui.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (TbRoleMenu)表控制层
 *
 * @author makejava
 * @since 2020-02-25 12:47:43
 */
@RestController
@RequestMapping("tbRoleMenu")
public class TbRoleMenuController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 服务对象
     */
    @Resource
    private TbRoleMenuService tbRoleMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbRoleMenu selectOne(String id) {
        return this.tbRoleMenuService.queryById(id);
    }


    @PostMapping("/permissionSubmit")
    public ResultVO permissionSubmit(HttpServletRequest request, RoleMenuInfo info){
        logger.info("更新角色权限信息");
        tbRoleMenuService.deleteAndInsertByRoleId(info,request);

        return ResultVOUtil.success();
    }

}