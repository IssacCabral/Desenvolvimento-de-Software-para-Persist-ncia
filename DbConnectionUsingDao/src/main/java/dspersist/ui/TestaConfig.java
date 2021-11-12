package dspersist.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestaConfig {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String filePath = "src\\main\\resources\\config.properties";
        properties.load(new FileInputStream(filePath));
        System.out.println(properties.getProperty("dbuser"));

    }
}
