package com.issaccabral.t2_studantssubjects.controller;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;
import com.issaccabral.t2_studantssubjects.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentController {
    public static Student createStudent(){
        String cpf = JOptionPane.showInputDialog("CPF");
        String registration = JOptionPane.showInputDialog("MATRICULA");
        String name = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        int year = Integer.parseInt(JOptionPane.showInputDialog("ANO"));
        int month = Integer.parseInt(JOptionPane.showInputDialog("MÊS"));
        int dayOfMonth = Integer.parseInt(JOptionPane.showInputDialog("DIA DO MÊS"));
        LocalDate borneDate = LocalDate.of(year, month, dayOfMonth);

        Student student = new Student(cpf, registration, email, name, borneDate);
        return student;
    }

    public static String findAll(StudentRepository studentRepository){
        String aux = "";
        for(Student student : studentRepository.findAll()){
            aux += student + "\n";
        }
        return aux;
    }

    public static String findNameAndSubjectsOfStudent(){
        String subString = JOptionPane.showInputDialog("DIGITE A SUBSTRING");
        return subString;
    }
}
