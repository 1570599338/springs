package com.lquan.layui.controller;

import com.lquan.layui.bean.resp.QuestionResult;
import com.lquan.layui.domain.Queoption;
import com.lquan.layui.domain.Question;
import com.lquan.layui.dto.resp.ResultSurveryData;
import com.lquan.layui.service.QueoptionService;
import com.lquan.layui.service.QuestionService;
import com.lquan.layui.validator.JwtIgnore;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2022-01-05 23:50:58
 */
@Slf4j
@RestController
@RequestMapping("question")
public class QuestionController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionService questionService;
    /**
     * 服务对象
     */
    @Resource
    private QueoptionService queoptionService;

    @JwtIgnore
    @RequestMapping("/search")
    public ResultSurveryData search(@RequestParam(required = false,value = "templateid") Integer templateid) throws InvocationTargetException, IllegalAccessException {

        Question question = new Question();
        log.info("template:{},projectID:{}",question,templateid);
        question.setTemplateid(templateid);
        List<Question> list =  questionService.queryAllByBean(question);
        if(list==null || list.size()<=0){
            return ResultSurveryData.bulidSuccessPageResult(list);
        }
        // project.setActive(Integer.valueOf(para.getIsQuery()));
        List<QuestionResult> results = new ArrayList<>();

        for(Question bean :list){
            QuestionResult questionResult = new QuestionResult();
            Queoption queoption = new Queoption();
            queoption.setQuestionid(bean.getId());
            List<Queoption> listopti = queoptionService.queryAllByBean(queoption);
            BeanUtils.copyProperties(questionResult,bean);
            questionResult.setOptions(listopti);
            results.add(questionResult);
        }
        return ResultSurveryData.bulidSuccessPageResult(results);


    }

    /**
     * 分页查询
     *
     * @param question 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Question>> queryByPage(Question question, PageRequest pageRequest) {
        return ResponseEntity.ok(this.questionService.queryByPage(question, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Question> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.questionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param question 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Question> add(Question question) {
        return ResponseEntity.ok(this.questionService.insert(question));
    }

    /**
     * 编辑数据
     *
     * @param question 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Question> edit(Question question) {
        return ResponseEntity.ok(this.questionService.update(question));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.questionService.deleteById(id));
    }

}

