package com.lquan.layui.bean.req.survery;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@ToString
public class ProjectOptionPara {
    /**
     * beginDate:"2022-01-08"
     * director:"项目经理"
     * endDate:"2022-01-09"
     * mebers:"项目成员"
     * name:"项目1"
     * quotaServiceState:1
     * remark:"备注"
     * type:1
     * typeName:"1"
     *
     *
     */

    private Integer id;

    private String number;

    private String name;

    private Integer type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String director;

    private String mebers;
    /**
     * 1 - stop；2 - running
     */
    private Integer quotaServiceState;

    private String remark;
    /**
     * 项目状态;0-初始，1-进行中，2-冻结，3-结束
     */
    private Integer state;

    private String typeName;
    private Integer typeCode;

}
