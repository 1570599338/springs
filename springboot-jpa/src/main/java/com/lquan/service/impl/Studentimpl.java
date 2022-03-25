package com.lquan.service.impl;

import com.lquan.dao.StudentRep;
import com.lquan.entry.Student;
import com.lquan.service.IStudent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springs
 * @description:
 * @author: lquan
 * @create: 2022-03-25 19:48
 **/
@Service
public class Studentimpl  implements IStudent {

    @Resource
    private StudentRep studentRep;

    /**
     * jpa 自己封装的方法
     * @param id
     * @return
     */
    @Override
    public Student findStudentByid(Integer id) {
        return studentRep.findOne(id);
    }
}
