package learn.beanassembly.assembly02;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Component
public class HelloWorld {
	private int age = 18;
	private Date birthday = new Date();
	private String name = "张三";
}
