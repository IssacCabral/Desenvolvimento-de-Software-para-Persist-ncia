package com.issaccabral.t2_studantssubjects.repository;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    public Subject findFirstByCode(String code);

    @Query("select s from Subject s where s.name like :name%")
    public List<Student> findByNameInitBy(String name);

    @Query("SELECT s FROM Subject c JOIN c.studentHasSubjects sc JOIN sc.student s  WHERE c.code = :code")
    public List<Student> findStudentsByCodeOfSubject(@Param("code") String code);
}
