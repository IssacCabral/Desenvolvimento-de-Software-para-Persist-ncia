import java.io.*;

public class TestaSaida {
    public static void main(String[] args) throws IOException {
        /*
         Para escrever no arquivo utilizamos o BufferedWriter.
         Nas aulas anteriores, vimos que podemos ler do arquivo
         e ler do teclado. Mas o Buffered serve também para
         você armazenar os dados para salvar. Se você salvar sem
         o Buffered, usualmente demore muito mais, porque você
         meio que vai salvando byte à byte. E para evitar essa demora
         você junta(faz um bloco) de dados para você salvar de uma vez só
         um bloco maior.
        */

        OutputStream os = new FileOutputStream("saida.txt", false);
        OutputStreamWriter osw = new OutputStreamWriter(os); // A mesma questão do tipo de codificação
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("java");
        bw.newLine();
        bw.close();

        /*
            De maneira simplificada, definimos o arquivo saida.txt, instanciamos
            o FileOutputStream a partir da classe abstrata OutputStream.
            Após isso instanciamos um OutputStreamWriter e passamos os como parâmetro
            encapsulando-o dentro do osw.

            IMPORTANTE!
            FileOutputStream pode receber um booleano como segundo
            parâmetro, para indicar se você quer reescrever o arquivo ou manter
            o que já estava escrito (append).
            false -> você reescreve
            true -> você mantém o que já estava
        */
    }
}
