package learn.beanassembly.assembly01;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConguration {

	@Bean
	public HelloWorld helloworld() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setAge(18);
		helloWorld.setBirthday(new Date());
		helloWorld.setName("张三");
		return helloWorld;
	}

}