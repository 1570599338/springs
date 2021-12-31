package com.lquan.layui.controller;

/*import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com. study.excel.ExcelUtils;
import com. study.excel.PatrolItemData;*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Package: com. study.controller
 * @ClassName: TestExcel
 * @Author: zhoukaishun
 * @CreateTime: 2021/12/8 18:18
 * @Description:
 */
@RestController
@RequestMapping("testExcel")
@Slf4j
public class TestExcel {

   /* @Resource
    private ExcelUtils excelUtils;

    @GetMapping("read")
    public String readExcel() {
        StringBuilder result = new StringBuilder();
        *//**
         * 防疫服务
         *//*
        String epidemicPreventionService = "D:\\excel\\epidemicPreventionService.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        log.info("读取" + epidemicPreventionService + "开始");
        EasyExcel.read(epidemicPreventionService, PatrolItemData.class, new PageReadListener<PatrolItemData>(
                dataList -> {
                    excelUtils.handle(dataList, 2);
                    result.append(epidemicPreventionService + "读取完毕，共：" + dataList.size() + "条记录;\n");
                })).sheet().doRead();
        log.info(epidemicPreventionService + "读取完毕");

        *//**
         * 展示区服务
         *//*
        String exhibitionAreaService = "D:\\excel\\exhibitionAreaService.xlsx";
        log.info("读取" + exhibitionAreaService + "开始");
        EasyExcel.read(exhibitionAreaService, PatrolItemData.class, new PageReadListener<PatrolItemData>(dataList -> {
            excelUtils.handle(dataList, 1);
            result.append(exhibitionAreaService + "读取完毕，共：" + dataList.size() + "条记录;\n");
        })).sheet().doRead();
        log.info(exhibitionAreaService + "读取完毕");

        *//**
         * 岗位服务
         *//*
        String postService = "D:\\excel\\postService.xlsx";
        log.info("读取" + postService + "开始");
        EasyExcel.read(postService, PatrolItemData.class, new PageReadListener<PatrolItemData>(dataList -> {
            excelUtils.handle(dataList);
            result.append(postService + "读取完毕，共：" + dataList.size() + "条记录;\n");
        })).sheet().doRead();
        log.info(postService + "读取完毕");
        return result.toString();
    }
*/


}
