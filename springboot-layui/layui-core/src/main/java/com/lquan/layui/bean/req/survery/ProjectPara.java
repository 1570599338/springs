package com.lquan.layui.bean.req.survery;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProjectPara {
    private String subSys;//: 'wesurvey',
    private String repID;//: repID,
    private String isQuery;//: '1',
    private String dispType;//: '12',
    private String perRows;//: '2000',
    private String cnd_type;//: state,
    private String selCndIDs;//: 'type'
}
