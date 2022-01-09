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

import javax.swing.*;
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

            if(op.equals("7")){break;}
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
                    StudentHasSubject studentHasSubject = StudentHasSubjectController.createRelation();
                    studentHasSubjectRepository.save(studentHasSubject);
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
                                String subString = StudentController.findNameAndSubjectsOfStudent();
                                JOptionPane.showMessageDialog(null, studentRepository.findNameAndSubjectsOfStudent(subString));
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Entrada inválida!");
                        }
                    }
                    break;
                case "7":
            }
        }
    }
}
