package com.issaccabral.t2_studantssubjects.controller;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;
import com.issaccabral.t2_studantssubjects.repository.StudentHasSubjectRepository;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;

import javax.swing.*;
import java.util.List;

public class StudentHasSubjectController {
    public static void createRelation(StudentHasSubjectRepository studentHasSubjectRepository){
        int studentId = Integer.parseInt(JOptionPane.showInputDialog("ID DO ESTUDANTE"));
        int subjectId = Integer.parseInt(JOptionPane.showInputDialog("ID DA DISCIPLINA"));

        StudentHasSubject studentHasSubject = new StudentHasSubject(studentId, subjectId);
        studentHasSubjectRepository.save(studentHasSubject);
    }

    public static String findAll(StudentHasSubjectRepository sp){
        String aux = "";
        for(StudentHasSubject studentHasSubject : sp.findAll()){
            aux += studentHasSubject + "\n";
        }
        return aux;
    }
}
