package com.rogers.demo.service;

import com.rogers.demo.entity.Student;
import com.rogers.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    final private StudentRepository studentRepository;
    @Autowired
    StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }

    public Student addNewStudent(final Student student){
       return studentRepository.save(student);
    }

    public void deleteStudent(final Long studentId){
        studentRepository.deleteStudentById(studentId);
    }
}
