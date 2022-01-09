package com.issaccabral.t2_studantssubjects.service;

import com.issaccabral.t2_studantssubjects.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void checkCpf(String cpf){
        try{
            if(studentRepository.findByCpfNamedQuery(cpf) != null){
                throw new Exception("Já existe este cpf");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
