package com.lquan.controller;

import java.util.List;

import com.lquan.bean.Resp.AjaxResult;
import com.lquan.common.page.TableDataInfo;
import com.lquan.common.poi.ExcelUtil;
import com.lquan.domain.About;
import com.lquan.service.IAboutService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 关于我们Controller
 *
 * @author
 * @date 2022-02-21
 */
@Controller
@RequestMapping("/admin/about")
public class AboutController extends BaseController {
    private String prefix = "admin/about";

    @Autowired
    private IAboutService aboutService;

    @RequiresPermissions("system:about:view")
    @GetMapping()
    public String about() {
        return prefix + "/about";
    }

    /**
     * 查询关于我们列表
     */
    @RequiresPermissions("system:about:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(About about) {
        startPage();
        List<About> list = aboutService.selectAboutList(about);
        return getDataTable(list);
    }

    /**
     * 导出关于我们列表
     */
    @RequiresPermissions("system:about:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(About about) {
        List<About> list = aboutService.selectAboutList(about);
        ExcelUtil<About> util = new ExcelUtil<About>(About.class);
        return util.exportExcel(list, "about");
    }

    /**
     * 新增关于我们
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存关于我们
     */
    @RequiresPermissions("system:about:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(About about) {
        return toAjax(aboutService.insertAbout(about));
    }

    /**
     * 修改关于我们
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        About about = aboutService.selectAboutById(id);
        mmap.put("about", about);
        return prefix + "/edit";
    }

    /**
     * 修改保存关于我们
     */
    @RequiresPermissions("system:about:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(About about) {
        return toAjax(aboutService.updateAbout(about));
    }

    /**
     * 删除关于我们
     */
    @RequiresPermissions("system:about:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(aboutService.deleteAboutByIds(ids));
    }
}
