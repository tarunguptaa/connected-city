package connected.city;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError() {
		return "no";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}