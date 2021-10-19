import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException{
        Properties prop = new Properties();

        prop.load(new FileInputStream("config.properties"));

        int linha_inicial = Integer.parseInt(prop.getProperty("linha_inicial"));
        int linha_final = Integer.parseInt(prop.getProperty("linha_final"));

        InputStream is = new FileInputStream(args[0]);
        Scanner entrada = new Scanner(is);

        int i = 1;
        while(i <= linha_final){
            String linha = entrada.nextLine();
            if(i >= linha_inicial){
                System.out.println(linha);
            }
            i++;
        }

        entrada.close();
        is.close();
    }
}
