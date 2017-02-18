package dasensio.java.course.web.atendee;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dasensio.java.course.domain.atendee.Atendee;
import dasensio.java.course.service.atendee.IAtendeeService;

@Controller
@RequestMapping(value = "atendee")
public class AtendeeController {

	@Autowired
	private IAtendeeService atendeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String findAll(final Model model) {
		model.addAttribute("atendees", atendeeService.getAtendees());
		model.addAttribute("atendeeForm", new Atendee());
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute("atendeeForm") @Valid final Atendee atendee, final BindingResult result,
			final Model model) {
		atendeeService.create(atendee);
		return findAll(model);
	}

}
