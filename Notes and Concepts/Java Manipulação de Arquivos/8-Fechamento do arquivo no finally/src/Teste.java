import java.io.BufferedReader;
import java.io.File;

public class Teste {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new File("arquivo.txt"));
        }

        /*No java 7 a estrutura try-with-resources executará o close automático
        * dos recursos declarados no try(), que implementam a interface java.lang.AutoClosable
        * (Readers, Writers, Streams)*/
    }
}
