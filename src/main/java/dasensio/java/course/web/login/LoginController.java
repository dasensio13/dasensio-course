package dasensio.java.course.web.login;

import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String loginPage(final ServletRequest request, final Model model) {

		Map<String, String[]> paramMap = request.getParameterMap();

		if (paramMap.containsKey("error")) {
			model.addAttribute("message", "Invalid username and password.");
			model.addAttribute("messageClass", "alert-error");
		}

		if (paramMap.containsKey("logout")) {
			model.addAttribute("message", "You have been logged out.");
			model.addAttribute("messageClass", "alert-success");
		}

		return "loginPage";
	}

}
