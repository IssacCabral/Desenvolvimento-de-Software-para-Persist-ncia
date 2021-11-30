import java.io.*;
import java.util.Scanner;

public class TestaEntrada {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        while(s != null){
            System.out.println(s);
            s = br.readLine();
        }

    }
}
