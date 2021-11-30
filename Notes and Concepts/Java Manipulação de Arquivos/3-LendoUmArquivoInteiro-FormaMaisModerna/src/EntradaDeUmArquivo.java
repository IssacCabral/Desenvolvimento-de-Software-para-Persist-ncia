import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class EntradaDeUmArquivo {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");

        Scanner entrada = new Scanner(is); // Como default, está setado para UTF-8
        //Scanner entrada = new Scanner(is, "UTF-8");
        //Scanner entrada = new Scanner(is, "ISO-8859-1");

        while(entrada.hasNextLine()){
            System.out.println(entrada.nextLine());
        }

        is.close();

        /*
        * Você tem a entrada, você ler o arquivo na linha 9,
        * e Instancia um new Scanner recebendo o objeto InputStream como parâmetro.
        *
        * eae voce faz diretamente no laço a leitura com o método hasNextLine.
        * Ou seja, se tiver a próxima linha ele carrega a próxima linha e
        * entrada.nextLine() mostra essa linha.
        *
        * Da mesma forma que o InputStreamReader, o Scanner já vai permitir que a gente
        * defina a codificação no construtor
        * */
    }
}
