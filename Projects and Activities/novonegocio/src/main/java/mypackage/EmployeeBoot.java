package mypackage;

import mypackage.dao.IEmployeeDAO;
import mypackage.entity.Employee;
import mypackage.ui.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EmployeeBoot implements CommandLineRunner {
    @Autowired
    private View view;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(EmployeeBoot.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.run();
    }
}
