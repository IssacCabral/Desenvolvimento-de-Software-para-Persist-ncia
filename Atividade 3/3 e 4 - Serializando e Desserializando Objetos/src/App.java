import model.Person;
import controller.Serializa;

public class App {
    public static void main(String[] args) {
        Serializa serializa = new Serializa();

        serializa.createPerson("01","Issac", 17);
        serializa.createPerson("02","Henrique", 27);
        serializa.createPerson("03","Ana", 23);

        //serializa.serializeObjectsAPIJava();
        serializa.deserializeObjectsAPIJava();
    }
}
