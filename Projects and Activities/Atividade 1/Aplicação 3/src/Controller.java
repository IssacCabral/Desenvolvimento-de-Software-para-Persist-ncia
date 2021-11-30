import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private String origem;
    private String destino;

    public void setNames(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do arquivo origem: ");
        this.origem = scanner.nextLine();

        System.out.println("Nome do arquivo destino: ");
        this.destino = scanner.nextLine();
    }

    public void manipula(){
        try{
            FileInputStream in = new FileInputStream(origem);
            FileOutputStream out = new FileOutputStream(destino);

            Long tempoInicial = System.currentTimeMillis();
            int x;
            while((x = in.read()) != -1){
                out.write(x);
            }
            Long tempoTotal = System.currentTimeMillis() - tempoInicial;
            System.out.println("Tempo total da cópia: " + tempoTotal);

            in.close();
            out.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

}
