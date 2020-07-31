package connected.city;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CityControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void invalidInputTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/kgkhk", String.class)).contains("no");
	}
	
	@Test
	public void nullInputTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?city1=&city2=", String.class)).contains("no");
	}
	
	@Test
	public void validInputTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?city1=Boston&city2=New York", String.class)).contains("yes");
	}
	
	@Test
	public void validInputReverseDataTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?city1=New York&city2=Boston", String.class)).contains("yes");
	}
}
