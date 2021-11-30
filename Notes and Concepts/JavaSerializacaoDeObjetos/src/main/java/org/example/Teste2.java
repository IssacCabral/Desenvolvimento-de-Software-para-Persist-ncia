package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste2 {
    public static void main(String[] args) {
        try{
            XmlMapper xmlMapper = new XmlMapper();
            Pessoa p1 = new Pessoa(1, "João");
            Pessoa p2 = new Pessoa(2, "Maria");
            List<Pessoa> pessoas = new ArrayList<>();
            pessoas.add(p1);
            pessoas.add(p2);

            File f = new File("pessoas.xml");
            xmlMapper.writeValue(f, pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
