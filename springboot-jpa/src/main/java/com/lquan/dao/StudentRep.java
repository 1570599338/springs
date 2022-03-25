package com.lquan.dao;

import com.lquan.entry.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface StudentRep extends JpaRepository<Student,Integer> {

}

