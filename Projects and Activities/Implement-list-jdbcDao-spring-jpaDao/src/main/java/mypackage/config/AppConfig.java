package mypackage.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static Properties getConfig(){
        Properties props = new Properties();
        try{
            InputStream is = AppConfig.class.getResourceAsStream("/config.properties");
            props.load(is);
        } catch (IOException e){
            e.printStackTrace();
        }
        return props;
    }
}
