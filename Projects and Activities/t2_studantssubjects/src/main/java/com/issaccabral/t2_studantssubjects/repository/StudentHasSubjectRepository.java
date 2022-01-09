package com.issaccabral.t2_studantssubjects.repository;

import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentHasSubjectRepository extends JpaRepository<StudentHasSubject, Integer> {
//    @Query("SELECT sc FROM StudentCourse sc WHERE sc.studentId = :studentId AND sc.courseId = :courseId")
//    public List<StudentHasSubject> findByStudentIdAndSubjectId(int studentId, int subjectId);
}
