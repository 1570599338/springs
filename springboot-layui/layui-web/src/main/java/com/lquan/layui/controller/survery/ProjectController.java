package com.lquan.layui.controller.survery;

import com.lquan.layui.bean.req.survery.ProjectPara;
import com.lquan.layui.bean.req.survery.UserPara;
import com.lquan.layui.domain.Project;
import com.lquan.layui.domain.TbUser;
import com.lquan.layui.dto.resp.ResultSurveryData;
import com.lquan.layui.enums.ResultCodeEnum;
import com.lquan.layui.service.ProjectService;
import com.lquan.layui.validator.JwtIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (Project)表控制层
 *
 * @author makejava
 * @since 2022-01-05 01:12:44
 */
@Slf4j
@RestController
@RequestMapping("project")
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;


    @JwtIgnore
    @RequestMapping("/sysmngJsonreport")
    public ResultSurveryData loginx(HttpServletResponse response, ProjectPara para ) {

        Project project = new Project();
        log.info("project:{},para:{}",project,para);
       // project.setActive(Integer.valueOf(para.getIsQuery()));
       List<Project> list =  projectService.queryAllByBean(project);
       return ResultSurveryData.bulidSuccessPageResult(list);


    }

    /**
     * 分页查询
     *
     * @param project 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Project>> queryByPage(Project project, PageRequest pageRequest) {
        return ResponseEntity.ok(this.projectService.queryByPage(project, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Project> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.projectService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param project 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Project> add(Project project) {
        return ResponseEntity.ok(this.projectService.insert(project));
    }

    /**
     * 编辑数据
     *
     * @param project 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Project> edit(Project project) {
        return ResponseEntity.ok(this.projectService.update(project));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.projectService.deleteById(id));
    }

}

