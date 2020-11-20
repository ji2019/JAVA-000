package learn.beanassembly.assembly03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import learn.beanassembly.bean.BeanConfig;
import learn.beanassembly.bean.HelloWorld;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@Import(BeanConfig.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        log.info(helloWorld.toString());
    }
}