package dasensio.java.course.web.attendee;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dasensio.java.course.domain.attendee.Attendee;
import dasensio.java.course.service.attendee.IAttendeeService;

@Controller
@RequestMapping(value = "attendee")
public class AttendeeController {

	@Autowired
	private IAttendeeService attendeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String findAll(final Model model) {
		model.addAttribute("attendees", attendeeService.getAttendees());
		model.addAttribute("attendeeForm", new Attendee());
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@ModelAttribute("attendeeForm") @Valid final Attendee attendee, final BindingResult result,
			final Model model) {
		// TODO validate entity here, show errors in form and delete @Valid
		attendeeService.create(attendee);
		return findAll(model);
	}

}
