package com.lquan.bean.req;

import com.lquan.domain.TbQuartzJob;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReqQuartzJobDto extends TbQuartzJob {
    //size数
    private String pageSize = "10";
    //当前页数
    private String pageNum;
}
