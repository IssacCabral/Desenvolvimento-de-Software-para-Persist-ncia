package com.issaccabral.t2_studantssubjects.controller;

import com.issaccabral.t2_studantssubjects.entity.Student;
import com.issaccabral.t2_studantssubjects.entity.StudentHasSubject;
import com.issaccabral.t2_studantssubjects.entity.Subject;
import com.issaccabral.t2_studantssubjects.repository.StudentRepository;
import com.issaccabral.t2_studantssubjects.service.StudentService;
import net.bytebuddy.asm.Advice;
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

    public static String findNameAndSubjectsOfStudent(StudentRepository studentRepository){
        String subString = JOptionPane.showInputDialog("DIGITE A SUBSTRING");
        String aux = "";
        List<Student> studentList = studentRepository.findNameAndSubjectsOfStudent(subString);
        for(Student student : studentList){
            aux += "name: " + student.getName() + "\n{";
            List<StudentHasSubject> studentHasSubjects = student.getStudentHasSubjects();
            for(StudentHasSubject x : studentHasSubjects){
                aux += "Subject Name: " + x.getSubject().getName() + " ";
            }
            aux += "}\n";
        }
        return aux;
    }

    public static int deleteStudent(StudentRepository studentRepository){
        int idStudent = Integer.parseInt(JOptionPane.showInputDialog("ID DO ALUNO A SER DELETADO"));
        return idStudent;
    }

    public static void updateStudent(StudentRepository studentRepository){
        int idStudent = Integer.parseInt(JOptionPane.showInputDialog("ID DO ESTUDANTE A SER ATUALIZADO"));
        Student student = studentRepository.getById(idStudent);

        String name = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        int year = Integer.parseInt(JOptionPane.showInputDialog("ANO"));
        int month = Integer.parseInt(JOptionPane.showInputDialog("MÊS"));
        int dayOfMonth = Integer.parseInt(JOptionPane.showInputDialog("DIA DO MÊS"));
        LocalDate borneDate = LocalDate.of(year, month, dayOfMonth);

        student.setName(name);
        student.setEmail(email);
        student.setBornDate(borneDate);

    }

    public static String findByRegistration(){
        String registration = JOptionPane.showInputDialog("NÚMERO DE MATRÍCULA DO ALUNO: ");
        return registration;
    }

    public static String findByDate(StudentRepository studentRepository){
        int year = Integer.parseInt(JOptionPane.showInputDialog("ANO"));
        int month = Integer.parseInt(JOptionPane.showInputDialog("MÊS"));
        int day = Integer.parseInt(JOptionPane.showInputDialog("DIA"));

        LocalDate bornDate = LocalDate.of(year, month, day);
        String aux = "";
        List<Student> dates = studentRepository.findByDate(bornDate);
        for(Student student : dates){
            aux += student + "\n";
        }
        return aux;
    }
}
