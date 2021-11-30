package controller;

import model.Livro;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializaCsv {
    private List<Livro> livros;

    public SerializaCsv(){
        this.livros = new ArrayList<>();
    }

    private boolean checkLivro(String titulo){
        for(int i = 0; i < livros.size(); i++){
            if(livros.get(i).getTitulo().equals(titulo)){
                return false;
            }
        }
        return true;
    }

    public List<Livro> getLivros(){return this.livros;}

    public void cadastrarLivro(){
        try{
            String[] tokens = JOptionPane.showInputDialog("Digite os dados do livro " +
                                                          "na ordem " +
                                                          "(Título, isbn, editora, anoPublicação): ")
                                                           .split(", ");
            if(!checkLivro(tokens[0])){
                throw new Exception("Fail: um livro com esse nome ja existe!");
            }
            Livro livro = new Livro(tokens[0], tokens[1], tokens[2], tokens[3]);
            this.livros.add(livro);
        }catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Fail: provavelmente você " +
                                                                        "esqueceu algum parâmetro");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void salvarLivrosCsv(){
        try{
            if(this.livros.size() == 0){
                throw new Exception("Fail: não possui livros cadastrados!");
            }
            String filePath = "src\\main\\resources\\livros.csv";
            OutputStream os = new FileOutputStream(filePath, true);
            PrintStream ps = new PrintStream(os);

            for(int i = 0; i < this.livros.size(); i++){
                Livro livro = livros.get(i);
                ps.println(livro.getTitulo() + "," + livro.getIsbn() + "," +
                           livro.getEditora() + "," + livro.getAnoPublicacao());
            }
            JOptionPane.showMessageDialog(null, "Livros salvos com sucesso!");
            this.livros.clear();
            ps.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String toString(){
        String aux = "";
        for(Livro livro: this.livros){
            aux += livro + "\n";
        }
        return aux;
    }
}
