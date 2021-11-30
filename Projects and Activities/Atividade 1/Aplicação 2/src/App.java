import java.io.*;
import java.util.Scanner;
import java.io.File;

public class App {
    public static void main(String[] args){
        Controller controller = new Controller();
        controller.setNames();
        controller.leitura();
        controller.escrita();
    }
}
