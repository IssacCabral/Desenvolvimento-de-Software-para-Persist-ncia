import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ReadingClass {
    private String nomeArquivo = "";

    public ReadingClass(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    private Properties readFile(){
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream(this.nomeArquivo));

            return prop;
        } catch (IOException ex){
            ex.getStackTrace();
            return null;
        }
    }

    public void display(){
        Properties pro = this.readFile();

        if(pro != null){
            for(Map.Entry<Object, Object> prop: pro.entrySet()){
                System.out.println(prop.getKey() + "=" + prop.getValue());
            }
        }else{
            System.out.println("Arquivo não encontrado");
        }
    }
}
