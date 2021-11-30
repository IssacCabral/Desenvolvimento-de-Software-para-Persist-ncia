import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LerArquivoPropriedades {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try{
            // Dessa maneira o arquivo só é encontrado caso esteja na raiz do projeto
            prop.load(new FileInputStream("config.properties"));
            // pega o valor da propriedade e o printa
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
