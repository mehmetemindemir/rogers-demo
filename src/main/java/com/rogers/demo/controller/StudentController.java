package com.rogers.demo.controller;

import com.rogers.demo.entity.Student;
import com.rogers.demo.exception.StudentNullException;
import com.rogers.demo.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;
    @Autowired
    StudentController(StudentService studentService){
        this.studentService=studentService;
    }


    @ApiOperation(value = "Fetch all student",response = Student.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200,message = "SUCCESS",response = Student.class),
            @ApiResponse(code = 401,message = "UNAUTHORIZED"),
            @ApiResponse(code = 403,message = "FORBIDDEN"),
            @ApiResponse(code = 404,message = "NOT FOUND"),
    })
    @GetMapping({"students/list"})
    public List<Student> getStudentList(){
        List<Student> students=null;
        try {
            students=studentService.getStudentList();

        }catch (Exception e){
            throw e;
        }
        return students;
    }

    @ApiOperation(value = "Insert an student",response = Student.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200,message = "SUCCESS",response = Student.class),
            @ApiResponse(code = 401,message = "UNAUTHORIZED"),
            @ApiResponse(code = 403,message = "FORBIDDEN"),
            @ApiResponse(code = 404,message = "NOT FOUND"),
    })
    @PostMapping({"student/add"})
    public Student addStudent(@RequestBody Student student){
        try {
            if(null==student || null==student.getName()){
                throw new StudentNullException();
            }
            studentService.addNewStudent(student);
        }catch (Exception e){
            throw e;
        }
        return student;
    }

    @ApiOperation(value = "Delete a student",response = Student.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200,message = "SUCCESS"),
            @ApiResponse(code = 401,message = "UNAUTHORIZED"),
            @ApiResponse(code = 403,message = "FORBIDDEN"),
            @ApiResponse(code = 404,message = "NOT FOUND"),
    })
    @DeleteMapping({"student/remove/{studentId:\\d+}"})
    public void deleteStudent(@PathVariable final Long studentId){
        studentService.deleteStudent(studentId);
    }
}
