package com.zrthas.springboot.Controller;

import com.zrthas.springboot.Dao.StudentRepository;
import com.zrthas.springboot.Entity.Student;
import com.zrthas.springboot.Entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DbTestController {

    @Autowired
    private StudentRepository studentDao;

    /**
     * 获取全部学生信息
     * @return
     */
    @GetMapping(value = "/getstudentlist")
    public List<Student> getStudentList(){
        return studentDao.findAll();
    }

    /**
     * 新增学生信息
     * @param age
     * @param name
     * @param score
     * @return
     */
    @PostMapping(value = "/poststudent")
    public Student addStudent(@RequestParam("age") String age,
                              @RequestParam("name") String name,
                              @RequestParam("score") String score){
        Student stu = new Student();
        stu.setAge(age);
        stu.setName(name);
        stu.setScore(score);
       return studentDao.save(stu);
    }
}
