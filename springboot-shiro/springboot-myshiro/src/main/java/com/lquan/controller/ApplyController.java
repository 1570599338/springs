package com.lquan.controller;

import java.util.List;

import com.lquan.bean.Resp.AjaxResult;
import com.lquan.common.page.TableDataInfo;
import com.lquan.common.poi.ExcelUtil;
import com.lquan.service.IApplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lquan.domain.Apply;

/**
 * 愿望申领单Controller
 *
 * @author lquan
 * @date 2022-02-23
 */
@Controller
@RequestMapping("/admin/apply")
public class ApplyController extends BaseController {
    private String prefix = "admin/apply";

    @Autowired
    private IApplyService applyService;

    @RequiresPermissions("system:apply:view")
    @GetMapping()
    public String apply() {
        return prefix + "/apply";
    }

    /**
     * 查询愿望申领单列表
     */
    @RequiresPermissions("system:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Apply apply) {
        startPage();
        List<Apply> list = applyService.selectApplyList(apply);
        return getDataTable(list);
    }

    /**
     * 导出愿望申领单列表
     */
    @RequiresPermissions("system:apply:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Apply apply) {
        List<Apply> list = applyService.selectApplyList(apply);
        ExcelUtil<Apply> util = new ExcelUtil<Apply>(Apply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 新增愿望申领单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存愿望申领单
     */
    @RequiresPermissions("system:apply:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Apply apply) {
        return toAjax(applyService.insertApply(apply));
    }

    /**
     * 修改愿望申领单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Apply apply = applyService.selectApplyById(id);
        mmap.put("apply", apply);
        return prefix + "/edit";
    }

    /**
     * 修改保存愿望申领单
     */
    @RequiresPermissions("system:apply:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Apply apply) {
        return toAjax(applyService.updateApply(apply));
    }

    /**
     * 删除愿望申领单
     */
    @RequiresPermissions("system:apply:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(applyService.deleteApplyByIds(ids));
    }
}
