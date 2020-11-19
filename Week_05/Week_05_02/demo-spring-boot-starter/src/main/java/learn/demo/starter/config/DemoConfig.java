package learn.demo.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learn.demo.starter.properties.DemoProperties;
import learn.demo.starter.service.DemoService;

/**
 * 描述：
 *
 **/
@Configuration
@EnableConfigurationProperties({ DemoProperties.class })
@ConditionalOnProperty(prefix = "demo", name = "isopen", havingValue = "true")
public class DemoConfig {
	
	@Autowired
	private DemoProperties demoProperties;

	@Bean
	public DemoService demoService() {
		return new DemoService(demoProperties);
	}

}
