package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Livro;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerializaXmlJson {
    private List<Livro> livros;

    public SerializaXmlJson(){
        this.livros = new ArrayList<>();
    }

    public void openCsvFile(){
        try{
            String filePath = "src\\main\\resources\\livros.csv";
            InputStream is = new FileInputStream(filePath);
            Scanner entrada = new Scanner(is);

            while(entrada.hasNextLine()){
                String[] tokens = entrada.nextLine().split(",");
                this.livros.add(new Livro(tokens[0], tokens[1], tokens[2], tokens[3]));
            }
            entrada.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void SerializeObjectsJson(){
        try {
            String filePath = "src\\main\\resources\\livros.json";

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filePath), this.livros);
            this.livros.clear();
            JOptionPane.showMessageDialog(null, "Objetos Serializados com sucesso!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void SerializeObjectsXml(){
        try{
            String filePath = "src\\main\\resources\\livros.xml";

            XmlMapper mapper = new XmlMapper();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filePath), this.livros);
            this.livros.clear();
            JOptionPane.showMessageDialog(null, "Objetos Serializados com sucesso!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for(Livro livro: this.livros){
            aux += livros + " \n";
        }
        return aux;
    }
}
