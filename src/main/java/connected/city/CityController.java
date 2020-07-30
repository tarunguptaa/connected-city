package connected.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CityController {

	@Autowired
	CityConnection connection;

	@RequestMapping("/connected")
	public String isConnected(@RequestParam String city1, @RequestParam String city2) {
		log.debug("Checking route between: ", city1, " and ", city2);
		if (city1 != null && city2 != null && connection.isConnectionAvailable(city1, city2)) {
			log.debug("Route found");
			return "yes";
		}
		log.debug("No route found");
		return "no";
	}
}
