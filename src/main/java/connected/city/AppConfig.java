package connected.city;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

	@Value("classpath:city.txt")
	private Resource resource;

	@Bean
	public CityConnection getCityConnection() {
		return new CityConnection(resource);
	}
}
