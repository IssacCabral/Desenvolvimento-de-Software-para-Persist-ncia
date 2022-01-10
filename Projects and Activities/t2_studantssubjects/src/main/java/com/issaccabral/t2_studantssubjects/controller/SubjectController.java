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

    public static String findStudentsByCodeOfSubject(SubjectRepository subjectRepository){
        String codeSubject = JOptionPane.showInputDialog(null, "CÓDIGO DA DISCIPLINA");
        String aux = "";
        for(Student student : subjectRepository.findStudentsByCodeOfSubject(codeSubject)){
            aux += student + "\n";
        }
        return aux;
    }

    public static int deleteSubject(SubjectRepository subjectRepository){
        int idSubject = Integer.parseInt(JOptionPane.showInputDialog("ID DA DISCIPLINA A SER DELETADA"));
        return idSubject;
    }

    public static void updateSubject(SubjectRepository subjectRepository){
        int idSubject = Integer.parseInt(JOptionPane.showInputDialog("ID DA DISCIPLINA A SER DELETADA"));

        String code = JOptionPane.showInputDialog("CODIGO");
        String name = JOptionPane.showInputDialog("NOME");

        subjectRepository.getById(idSubject).setCode(code);
        subjectRepository.getById(idSubject).setName(name);
    }
}
