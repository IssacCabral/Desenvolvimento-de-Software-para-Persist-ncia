import java.io.*;
import java.util.Scanner;

public class Controller {
    private String nomeArquivo = "";
    private String subString = "";

    public void getNames(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do arquivo: ");
        this.nomeArquivo = scanner.nextLine();

        System.out.println("Digite a subString: ");
        this.subString = scanner.nextLine();
    }

    public void leitura(){
        try{
            InputStream arquivo = new FileInputStream(nomeArquivo);
            Scanner entrada = new Scanner(arquivo);

            while(entrada.hasNextLine()){
                String linha = entrada.nextLine();
                if(linha.contains(this.subString)){
                    System.out.println(linha);
                }
            }
            arquivo.close();
            entrada.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
