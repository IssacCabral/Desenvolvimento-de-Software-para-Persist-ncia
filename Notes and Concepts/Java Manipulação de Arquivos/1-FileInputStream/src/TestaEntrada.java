import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestaEntrada {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");
        InputStreamReader isr = new InputStreamReader(is);
        //InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        //InputStreamReader isr = new InputStreamReader(is, "ISO-8859-1");

        char c = (char)isr.read();
        System.out.println(c);
        c = (char)isr.read();
        System.out.println(c);


        /*
        * Damos um new FileInputStream que extende a classe abstrata InputStream(polimorfismo)
        * e passamos o nosso arquivo para o construtor.
        *
        * esse nosso objeto do tipo InputStream, quando lermos algum caractere do documento
        * pode-se ter algum erro de leitura e não conseguir ler alguns caracteres especiais
        *
        * Para resolver isso, Encapsulamos o objeto is passando para o construtor
        * da classe InputStreamReader, pois ela vai tratar de cuidar dos caracteres especiais
        * no mesmo construtor podemos especificar que tipo de caracteres estamos usando:
        * UTF-8, ISO-8859-1 por ex...
        * */
    }
}
