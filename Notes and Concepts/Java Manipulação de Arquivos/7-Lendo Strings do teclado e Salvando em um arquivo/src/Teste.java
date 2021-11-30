import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream("arquivo2.txt"); // Se não houver o arquivo, é criado automaticamente

        while(s.hasNextLine()){
            ps.println(s.nextLine());
        }


    }
}
