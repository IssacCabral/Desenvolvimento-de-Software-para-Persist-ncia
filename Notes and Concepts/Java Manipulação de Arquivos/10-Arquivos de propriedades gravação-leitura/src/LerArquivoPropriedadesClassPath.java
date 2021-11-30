import java.io.IOException;
import java.util.Properties;

public class LerArquivoPropriedadesClassPath {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try{
            // para ler do path
            prop.load(LerArquivoPropriedadesClassPath.class.getClassLoader()
                    .getResourceAsStream("config.properties"));

            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
