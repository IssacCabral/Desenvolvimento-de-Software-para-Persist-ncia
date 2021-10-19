import java.io.*;
import java.util.Scanner;

public class Controller {
    private String origem;
    private String destino;
    private int bufferSize;

    private void setNames(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite: arquivo origem, arquivo destino, tamanho do bloco de bytes");
        try{
            String[] tokens = scanner.nextLine().split(" ");
            if(tokens.length < 3){
                throw new Exception("Parâmetros inválidos");
            }else{
                this.origem = tokens[0];
                this.destino = tokens[1];
                this.bufferSize = Integer.parseInt(tokens[2]);
            }
        } catch (NullPointerException e){
            System.out.println("Objeto nulo");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void manipula(){
        this.setNames();

        try{
            InputStream inputStream = new BufferedInputStream(new FileInputStream(this.origem));
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(this.destino));

            byte[] buffer = new byte[bufferSize];

            Long tempoInicial = System.currentTimeMillis();
            while(inputStream.read(buffer) != -1){
                outputStream.write(buffer);
            }
            Long tempoTotal = System.currentTimeMillis() - tempoInicial;
            System.out.println("Tempo total da cópia: " + tempoTotal + " ms");

            inputStream.close();
            outputStream.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
