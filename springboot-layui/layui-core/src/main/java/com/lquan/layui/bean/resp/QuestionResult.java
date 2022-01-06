package com.lquan.layui.bean.resp;

import com.lquan.layui.domain.Queoption;
import com.lquan.layui.domain.Question;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QuestionResult  extends Question {

    List<Queoption> options;
}
