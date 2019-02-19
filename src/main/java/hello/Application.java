package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

// @SpringBootApplication is a convenience annotation that adds:
// - @Configuration - tags the class as a source of bean definitions for the application context;
// - @EnableAutoConfiguration - tells Spring Boot to start adding beans based on classpath settings,
// other beans, and various property settings;
// - @EnableWebMvc - this flags the application as a web app and activates key behaviours such as
// setting up a DispatcherServlet;
// - @ComponentScan - tells Spring to look for other components, configurations, and services in
// the hello package, allowing it to find the controllers.
@SpringBootApplication
public class Application {

    // The main() method uses SpringApplication.run() method to launch an application.
    // This makes the use of XML for configuring unnecessary.
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // The CommandLineRunner method runs on startup and retrieves all the beans that were created
    // either by the app or automatically added by Spring Boot. It sorts and prints them.
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        }
    }
}
