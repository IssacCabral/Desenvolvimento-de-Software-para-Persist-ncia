package com.issaccabral.t2_studantssubjects.repository;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.search.IFindNameOfStudentWithSubjects;
import com.issaccabral.t2_studantssubjects.search.IStudentNameAndCountingSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Student findByName(String name);
    public Student findByEmail(String email);
    public Student findByRegistration(String registration);

//    @Query("SELECT e FROM Student e WHERE e.bornDate >= :bornDate")
//    public Set<Student> findByDate(@Param("bornDate") LocalDate bornDate);
    @Query("SELECT e FROM Student e WHERE e.bornDate >= :bornDate")
    public List<Student> findByDate(@Param("bornDate") LocalDate bornDate);

    @Query(name = "studentByCpf")
    public Student findByCpfNamedQuery(String cpf);

    @Query("SELECT e.name as name, COUNT(sc.id) as countOfSubjects FROM Student e JOIN e.studentHasSubjects sc GROUP BY e.name")
    public Set<IStudentNameAndCountingSubjects> findStudentsNameAndQuantityOfSubjects();

    @Query("select s from Student s where s.name like :name%")
    public List<Student> findByNameInitBy(String name);

//    @Query("SELECT s FROM Student s JOIN FETCH s.studentHasSubjects sc " +
//           "JOIN FETCH sc.subject c WHERE s.name LIKE CONCAT('%',:name,'%')")
//    public Set<IFindNameOfStudentWithSubjects> findNameAndSubjectsOfStudent(@Param("name") String name);
    @Query("SELECT s FROM Student s JOIN FETCH s.studentHasSubjects sc " +
           "JOIN FETCH sc.subject c WHERE s.name LIKE CONCAT('%',:name,'%')")
    public List<Student> findNameAndSubjectsOfStudent(@Param("name") String name);
}
