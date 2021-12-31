package com.lquan.layui.utils;

import lombok.Data;

/**
 * ClassName:    PageRequest
 * Package:    com. study.utils
 * Description:
 * Datetime:    2020/2/14   13:06
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
}
