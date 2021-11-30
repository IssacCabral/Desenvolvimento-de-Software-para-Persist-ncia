import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EscreveArquivoPropriedades {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try{
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "mkyong");
            prop.setProperty("dbpassword", "password");

            prop.store(new FileOutputStream("config.properties"), null);
        } catch (IOException ex){
            ex.printStackTrace();
        }


    }
}
