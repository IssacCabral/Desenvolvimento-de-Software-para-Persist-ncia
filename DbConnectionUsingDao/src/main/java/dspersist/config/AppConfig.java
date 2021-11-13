package dspersist.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class AppConfig {
//    public static Properties PROPS = null;
//    static{
//        try{
//            Properties prop = new Properties();
//            String filePath = "src\\main\\resources\\config.properties";
//            InputStream is = new FileInputStream(filePath);
//            //InputStream is = /*dspersist.config.AppConfig.class.getResourceAsStream*/new InputStreamReader(filePath);
//            System.out.println(is);
//            prop.load(is);
//            PROPS = prop;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    } OUTRA MANEIRA DE FAZER!!! MAS NÃO ENTENDI BEM, POR ISSO RESOLVI FAZER DO MEU JEITO!
    public static Properties getConfig(){
        Properties properties = new Properties();
        //String filePath = "src\\main\\resources\\config.properties";
        // EVITAR CAMINHO ABSOLUTO, SEGUNDO PROFESSOR!
        try{
            InputStream is = AppConfig.class.getResourceAsStream("/config.properties");
            properties.load(is);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return properties;
    }
}
