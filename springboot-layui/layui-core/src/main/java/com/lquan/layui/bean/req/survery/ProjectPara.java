package com.lquan.layui.bean.req.survery;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProjectPara {
    private String subSys;//: 'wesurvey',
    private Integer repID;//: repID,
    private Integer isQuery;//: '1',
    private Integer toPageNo;
    private Integer dispType;//: '12',
    private Integer perRows;//: '2000',
    private String cnd_type;//: state,
    private String selCndIDs;//: 'type'
    private String cnd_projectName;
}
