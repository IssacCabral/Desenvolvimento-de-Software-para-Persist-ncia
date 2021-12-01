package mypackage;

import mypackage.ui.ViewSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PlaySpring implements CommandLineRunner {
    @Autowired
    private ViewSpring viewSpring;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(PlaySpring.class);
        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception{
        viewSpring.run();
    }
}
