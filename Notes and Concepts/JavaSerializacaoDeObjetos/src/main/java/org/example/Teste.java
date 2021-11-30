package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Teste {
    public static void main(String[] args) {
        try{
            XmlMapper xmlMapper = new XmlMapper();
            Pessoa p = new Pessoa(1, "João");
            String xml = xmlMapper.writeValueAsString(p);
            System.out.println(xml);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
