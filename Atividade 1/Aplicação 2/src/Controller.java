import java.io.*;
import java.util.Scanner;

public class Controller {
    private String nomePrimeiroArquivo = "";
    private String nomeSegundoArquivo = "";
    private String nomeTerceiroArquivo = "";

    private InputStream arquivo1;
    private InputStream arquivo2;

    private Scanner entradaArquivo1;
    private Scanner entradaArquivo2;

    private PrintStream ps;

    public void setNames(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do primeiro arquivo");
        this.nomePrimeiroArquivo = scanner.nextLine();

        System.out.println("Nome do segundo arquivo");
        this.nomeSegundoArquivo = scanner.nextLine();

        System.out.println("Nome do terceiro arquivo");
        this.nomeTerceiroArquivo = scanner.nextLine();
    }

    public void leitura(){
        try{
            this.arquivo1 = new FileInputStream(nomePrimeiroArquivo); // acessando arquivo1
            this.entradaArquivo1 = new Scanner(arquivo1);

            this.arquivo2 = new FileInputStream(nomeSegundoArquivo); // acessando arquivo2
            this.entradaArquivo2 = new Scanner(arquivo2);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void escrita(){
        try{
            ps = new PrintStream(nomeTerceiroArquivo);

            Long tempoInicial = System.currentTimeMillis();
            while(entradaArquivo1.hasNextLine()){
                String linha = entradaArquivo1.nextLine();
                ps.println(linha);
            }
            while(entradaArquivo2.hasNextLine()){
                String linha = entradaArquivo2.nextLine();
                ps.println(linha);
            }
            // Imprimindo o tempo total da cópia
            Long tempoTotal = System.currentTimeMillis() - tempoInicial;
            System.out.println("Tempo total da cópia: " + tempoTotal);

            // Imprimindo o tamanho do novo arquivo
            File file = new File("C:\\Users\\PICHAU\\Desktop\\" +
                    "Java Manipulação de Arquivos\\Aplicação 2\\" + this.nomeTerceiroArquivo);
            long tamanho = file.length();
            System.out.println("Tamanho do arquivo: " + tamanho);

            entradaArquivo1.close();
            entradaArquivo2.close();
            ps.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
