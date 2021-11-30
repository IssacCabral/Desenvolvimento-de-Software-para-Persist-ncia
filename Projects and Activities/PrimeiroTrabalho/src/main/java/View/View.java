package View;

import controller.SerializaCsv;
import controller.SerializaXmlJson;

import javax.swing.*;

public class View {
    public void run(){
        SerializaCsv serializaCsv = new SerializaCsv();
        SerializaXmlJson serializaXmlJson = new SerializaXmlJson();

        while(true){
            String op = JOptionPane.showInputDialog("/// BEM VINDO AO SERIALIZADOR DE ARQUIVOS ///\n" +
                                                     "Escolha uma opção: \n\n" +
                                                     "cadas -- para cadastrar um livro \n" +
                                                     "save -- para salvar os livros\n" +
                                                     "show -- para mostrar os livros que estão para ser salvos no csv\n" +
                                                     "serialjson -- para serializar os livros em json\n" +
                                                     "serialxml -- para serializar os livros em xml\n" +
                                                     "end -- para sair\n");

            if(op.equals("end")) break;
            switch (op){
                case "cadas":
                    serializaCsv.cadastrarLivro();
                    break;
                case "save":
                    serializaCsv.salvarLivrosCsv();
                    break;
                case "show":
                    try{
                        if(serializaCsv.getLivros().size() == 0){
                            throw new Exception("Fail:não possui livros cadastrados!");
                        }
                        JOptionPane.showMessageDialog(null, serializaCsv);
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case "serialjson":
                    serializaXmlJson.openCsvFile();
                    serializaXmlJson.SerializeObjectsJson();
                    break;
                case "serialxml":
                    serializaXmlJson.openCsvFile();
                    serializaXmlJson.SerializeObjectsXml();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrada Inválida!");
            }
        }
    }
}
