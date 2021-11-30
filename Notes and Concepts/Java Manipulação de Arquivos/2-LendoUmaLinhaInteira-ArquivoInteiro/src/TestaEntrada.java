import java.io.*;

public class TestaEntrada {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("arquivo.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();
        while(s != null){
            System.out.println(s);
            s = br.readLine();
        }

        br.close(); // Liberando o espaço na memória
        
        /*
        *   O BufferedReader vai fazer uma Buferização, ou seja, vai armazenando
        * aquelas coisas em uma estrutura de dados para depois juntar isso, para poder
        * fazer alguam operação a seguir.
        *
        *   no BufferedReader temos o método readLine() para ler a linha inteira, ou seja,
        * ele vai ler e vai armazenar no Buffer até que seja encontrado um caractere de
        * quebra de linha, no caso desse arquivo, provavelmente um \n.
        *
        *   Essa leitura do Reader começa por pedaços, então ele vai trazendo
        * byte à byte. Pega o byte no InputStream, leva para o InputStreamReader, que por sua vez
        * faz uma análise(interpretação) disso, em seguida é devolvido um char para o BufferedReader
        * que por sua vez vai acumulando os caracteres até que seja lida toda a linha e formar uma String.
        *
        *   Isso é chamado de Padrão de composição Decorator Pattern.
        * */
    }
}
