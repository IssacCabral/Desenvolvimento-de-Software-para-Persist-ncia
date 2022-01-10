package com.issaccabral.t2_studantssubjects.view;

import com.issaccabral.t2_studantssubjects.controller.StudentController;
import com.issaccabral.t2_studantssubjects.controller.StudentHasSubjectController;
import com.issaccabral.t2_studantssubjects.controller.SubjectController;
import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;
import com.issaccabral.t2_studantssubjects.entity.Subject;
import com.issaccabral.t2_studantssubjects.repository.StudentHasSubjectRepository;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;
import com.issaccabral.t2_studantssubjects.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@EnableJpaRepositories("com.issaccabral.t2_studantssubjects.repository")
@EntityScan("com.issaccabral.t2_studantssubjects.entity")
@Service
public class View {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentHasSubjectRepository studentHasSubjectRepository;

    public void run(){
        while(true){
            String op = JOptionPane.showInputDialog(MenuView.MENU);

            if(op.equals("/")){break;}
            switch (op){
                case "1":
                    Student student = StudentController.createStudent();
                    studentRepository.save(student);
                    break;
                case "2":
                    Subject subject = SubjectController.createSubject();
                    subjectRepository.save(subject);
                    break;
                case "3":
                    StudentHasSubjectController.createRelation(studentHasSubjectRepository);
                    break;
                case "4":
                    String findAllStudent = StudentController.findAll(studentRepository);
                    JOptionPane.showMessageDialog(null, findAllStudent);
                    break;
                case "5":
                    String findAllSubject = SubjectController.findAll(subjectRepository);
                    JOptionPane.showMessageDialog(null, findAllSubject);
                    break;
                case "6":
                    while(true){
                        op = JOptionPane.showInputDialog(QueryView.VIEW);

                        if(op.equals("6")){break;}
                        switch (op){
                            case "1":
                                String result = StudentController.findNameAndSubjectsOfStudent(studentRepository);
                                JOptionPane.showMessageDialog(null, result);
                                break;
                            case "2":
                                String studentList =  SubjectController.findStudentsByCodeOfSubject(subjectRepository);
                                JOptionPane.showMessageDialog(null, studentList);
                                break;
                            case "3":
                                JOptionPane.showMessageDialog(null, studentRepository.findStudentsNameAndQuantityOfSubjects());
                                break;
                            case "4":
                                String registration = StudentController.findByRegistration();
                                JOptionPane.showMessageDialog(null, studentRepository.findByRegistration(registration));
                                break;
                            case "5":
                                String resultBornDate = StudentController.findByDate(studentRepository);
                                JOptionPane.showMessageDialog(null, resultBornDate);

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Entrada inválida!");
                        }
                    }
                    break;
                case "7":
                    int idStudent = StudentController.deleteStudent(studentRepository);
                    studentRepository.delete(studentRepository.getById(idStudent));
                    JOptionPane.showMessageDialog(null, "STUDENT DELETADO COM SUCESSO!");
                    break;
                case "8":
                    int idSubject = SubjectController.deleteSubject(subjectRepository);
                    subjectRepository.delete(subjectRepository.getById(idSubject));
                    JOptionPane.showMessageDialog(null, "DISCIPLINA DELETADA COM SUCESSO!");
                    break;
                case "9":
                    StudentController.updateStudent(studentRepository);
                    JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO");
                    break;
                case "10":
                    SubjectController.updateSubject(subjectRepository);
                    JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO");
                case "11":
                    JOptionPane.showMessageDialog(null, StudentHasSubjectController.findAll(studentHasSubjectRepository));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ENTRADA INVÁLIDA!");
            }
        }
    }
}
