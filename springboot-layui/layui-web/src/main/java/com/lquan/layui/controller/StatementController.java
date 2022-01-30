package com.lquan.layui.controller;

import com.lquan.layui.domain.Statement;
import com.lquan.layui.domain.Template;
import com.lquan.layui.dto.resp.ResultSurveryData;
import com.lquan.layui.service.StatementService;
import com.lquan.layui.validator.JwtIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Statement)表控制层
 * @author makejava
 * @since 2022-01-05 23:56:55
 */
@Slf4j
@RestController
@RequestMapping("statement")
public class StatementController {
    /**
     * 服务对象
     */
    @Resource
    private StatementService statementService;

    /**
     * 根据问卷id进行查询
     * @param templateid
     * @return
     */
    @JwtIgnore
    @RequestMapping("/search")
    public ResultSurveryData search(@RequestParam(required = false,value = "templateid") Integer templateid) {

        Statement statement = new Statement();
        log.info("statement:{},templateid:{}",statement,templateid);
        statement.setTemplateid(templateid);

        // project.setActive(Integer.valueOf(para.getIsQuery()));
        List<Statement> list =  statementService.queryAllByBean(statement);
        return ResultSurveryData.bulidSuccessPageResult(list);


    }

    /**
     * 分页查询
     *
     * @param statement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Statement>> queryByPage(Statement statement, PageRequest pageRequest) {
        return ResponseEntity.ok(this.statementService.queryByPage(statement, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Statement> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.statementService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param statement 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Statement> add(Statement statement) {
        return ResponseEntity.ok(this.statementService.insert(statement));
    }

    /**
     * 编辑数据
     *
     * @param statement 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Statement> edit(Statement statement) {
        return ResponseEntity.ok(this.statementService.update(statement));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.statementService.deleteById(id));
    }

}

