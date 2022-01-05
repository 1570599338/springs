package com.lquan.layui.controller.survery;

import com.lquan.layui.bean.req.survery.ProjectPara;
import com.lquan.layui.domain.Project;
import com.lquan.layui.domain.Template;
import com.lquan.layui.dto.resp.ResultSurveryData;
import com.lquan.layui.service.TemplateService;
import com.lquan.layui.validator.JwtIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * (Template)表控制层
 *
 * @author lquan
 * @since 2022-01-05 16:49:54
 */
@Slf4j
@RestController
@RequestMapping("/template")
public class TemplateController {

    /**
     * 服务对象
     */
    @Resource
    private TemplateService templateService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/get")
    public ResultSurveryData queryById(@RequestParam(required = false,value = "id")  Integer id) {
        Template template =this.templateService.queryById(id);
        List list = new ArrayList();
        list.add(template);
        return ResultSurveryData.bulidSuccessPageResult(list);
    }


    @JwtIgnore
    @RequestMapping("/search")
    public ResultSurveryData search(@RequestParam(required = false,value = "projectID") Integer projectID) {

       Template template = new Template();
        log.info("template:{},projectID:{}",template,projectID);
        template.setProjectid(projectID);

        // project.setActive(Integer.valueOf(para.getIsQuery()));
       List<Template> list =  templateService.queryAllByBean(template);
       return ResultSurveryData.bulidSuccessPageResult(list);


    }

    @JwtIgnore
    @RequestMapping("/update")
    public ResultSurveryData update( @RequestBody Template template ) {


        log.info("template:{}",template);

        templateService.update(template);

        // project.setActive(Integer.valueOf(para.getIsQuery()));
        List<Template> list =  new ArrayList<>(2);
        list.add(template);
        return ResultSurveryData.bulidSuccessPageResult(list);


    }


    /**
     * 分页查询
     *
     * @param template 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Template>> queryByPage(Template template, PageRequest pageRequest) {
        return ResponseEntity.ok(this.templateService.queryByPage(template, pageRequest));
    }


    /**
     * 新增数据
     *
     * @param template 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Template> add(Template template) {
        return ResponseEntity.ok(this.templateService.insert(template));
    }

    /**
     * 编辑数据
     *
     * @param template 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Template> edit(Template template) {
        return ResponseEntity.ok(this.templateService.update(template));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.templateService.deleteById(id));
    }

}

