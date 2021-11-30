import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Teste {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("saida.txt");
        ps.println("Java");
        ps.close();


    }
}
