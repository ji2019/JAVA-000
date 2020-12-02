package learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import learn.demo.starter.service.DemoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		DemoService demoService = context.getBean(DemoService.class);
		log.info(demoService.say());
	}
}