package org.seriobjetos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.seriobjetos.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializa {
    List<Person> personList;

    public Serializa(){
        this.personList = new ArrayList<>();
    }

    public void createPerson(String id, String name, int age){
        try{
            if(age <= 0){
                throw new Exception("Fail: invalid age");
            }
            Person person = new Person(id, name, age);
            personList.add(person);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void serializeObjectsAPIJava(){
        for(int i = 0; i < this.personList.size(); i++){
            try{
                FileOutputStream fos = new FileOutputStream("resources/Person" + (i+1) + ".ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.personList.get(i));
                oos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void deserializeObjectsAPIJava(){
        for(int i = 0; i < this.personList.size(); i++){
            try{
                FileInputStream fis = new FileInputStream("resources/Person" + (i+1) + ".ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Person person = (Person)ois.readObject();
                System.out.println(person);
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }

    }

    public void serializeObjectsJSON(){
        for(int i = 0; i < this.personList.size(); i++){
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File("resources/Person" + (i+1) + ".json"), this.personList.get(i));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void serializeObjectsXML(){
        for(int i = 0; i < this.personList.size(); i++){
            try{
                XmlMapper mapper = new XmlMapper();
                mapper.writeValue(new File("resources/Person" + (i+1) + ".xml"), personList.get(i));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        String aux = "";

        for(Person person: this.personList){
            aux += person + "\n";
        }
        return aux;
    }
}
