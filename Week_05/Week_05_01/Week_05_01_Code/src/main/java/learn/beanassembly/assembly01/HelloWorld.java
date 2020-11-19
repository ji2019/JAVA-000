package learn.beanassembly.assembly01;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class HelloWorld {
	private int age;
	private Date birthday;
	private String name;

	public HelloWorld(int age, Date birthday, String name) {
		super();
		this.age = age;
		this.birthday = birthday;
		this.name = name;
	}
}
