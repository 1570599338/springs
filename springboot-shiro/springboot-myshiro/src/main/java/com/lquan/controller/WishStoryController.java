package com.lquan.controller;

import java.util.List;

import com.lquan.bean.Resp.AjaxResult;
import com.lquan.common.page.TableDataInfo;
import com.lquan.common.poi.ExcelUtil;
import com.lquan.common.shiro.ShiroUtils;
import com.lquan.domain.Role;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lquan.domain.WishStory;
import com.lquan.service.IWishStoryService;

/**
 * 圆梦故事Controller
 *
 * @author lquan
 * @date 2022-02-24
 */
@Controller
@RequestMapping("/admin/story")
public class WishStoryController extends BaseController {
    private String prefix = "admin/story";

    @Autowired
    private IWishStoryService wishStoryService;

    @RequiresPermissions("system:story:view")
    @GetMapping()
    public String story() {
        return prefix + "/story";
    }

    /**
     * 查询圆梦故事列表
     */
    @RequiresPermissions("system:story:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WishStory wishStory) {
        startPage();
        List<WishStory> list = wishStoryService.selectWishStoryList(wishStory);
        return getDataTable(list);
    }

    /**
     * 导出圆梦故事列表
     */
    @RequiresPermissions("system:story:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WishStory wishStory) {
        List<WishStory> list = wishStoryService.selectWishStoryList(wishStory);
        ExcelUtil<WishStory> util = new ExcelUtil<WishStory>(WishStory.class);
        return util.exportExcel(list, "story");
    }

    /**
     * 新增圆梦故事
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存圆梦故事
     */
    @RequiresPermissions("system:story:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WishStory wishStory) {

        wishStory.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(wishStoryService.insertWishStory(wishStory));
    }

    /**
     * 修改圆梦故事
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        WishStory wishStory = wishStoryService.selectWishStoryById(id);
        mmap.put("wishStory", wishStory);
        return prefix + "/edit";
    }

    /**
     * 修改保存圆梦故事
     */
    @RequiresPermissions("system:story:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WishStory wishStory) {
        return toAjax(wishStoryService.updateWishStory(wishStory));
    }

    /**
     * 删除圆梦故事
     */
    @RequiresPermissions("system:story:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wishStoryService.deleteWishStoryByIds(ids));
    }

    /**
     * 角色状态修改
     */
    @RequiresPermissions("system:story:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(WishStory wishStory) {

        return toAjax(wishStoryService.updateWishStory(wishStory));
    }
}
