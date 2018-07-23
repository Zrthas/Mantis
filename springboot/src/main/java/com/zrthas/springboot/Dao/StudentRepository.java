package com.zrthas.springboot.Dao;

import com.zrthas.springboot.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
