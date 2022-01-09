package com.issaccabral.t2_studantssubjects.controller;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;

import javax.swing.*;
import java.util.List;

public class StudentHasSubjectController {
    public static StudentHasSubject createRelation(){
        int studentId = Integer.parseInt(JOptionPane.showInputDialog("ID DO ESTUDANTE"));
        int subjectId = Integer.parseInt(JOptionPane.showInputDialog("ID DA DISCIPLINA"));

        StudentHasSubject studentHasSubject = new StudentHasSubject(studentId, subjectId);
        return studentHasSubject;
    }


}
