package com.rogers.demo.repository;

import com.rogers.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Transactional
    @Modifying
    @Query("delete from student t where t.studentId=?1")
    void deleteStudentById(Long id);
    @Query("select s from student  s where s.studentId=?1")
    Student getStudentById(Long id);
}
