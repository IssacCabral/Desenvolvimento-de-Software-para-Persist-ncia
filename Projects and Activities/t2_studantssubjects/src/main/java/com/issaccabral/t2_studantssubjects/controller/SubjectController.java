package com.issaccabral.t2_studantssubjects.controller;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.Subject;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;
import com.issaccabral.t2_studantssubjects.repository.SubjectRepository;

import javax.swing.*;

public class SubjectController {
    public static Subject createSubject(){
        String code = JOptionPane.showInputDialog("CÓDIGO DISCIPLINA");
        String name = JOptionPane.showInputDialog("NOME");
        Subject subject = new Subject(code, name);
        return subject;
    }

    public static String findAll(SubjectRepository subjectRepository){
        String aux = "";
        for(Subject subject : subjectRepository.findAll()){
            aux += subject + "\n";
        }
        return aux;
    }
}
