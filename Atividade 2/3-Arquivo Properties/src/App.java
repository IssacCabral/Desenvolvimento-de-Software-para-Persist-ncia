import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Properties prop = new Properties();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo:");
        String fileName = scanner.nextLine();

        ReadingClass rc = new ReadingClass(fileName);
        rc.display();

    }
}
