package learn.beanassembly.assembly04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import learn.beanassembly.assembly01.HelloWorld;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ImportResource(locations = "classpath:learn/beanassembly/assembly04/spring-config.xml")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        log.info(helloWorld.toString());
    }
}