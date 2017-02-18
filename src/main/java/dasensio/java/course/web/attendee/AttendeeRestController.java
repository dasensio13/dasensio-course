package dasensio.java.course.web.attendee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dasensio.java.course.domain.attendee.Attendee;
import dasensio.java.course.service.attendee.IAttendeeService;

@RestController
@RequestMapping(value = "rest/attendee")
public class AttendeeRestController {

	@Autowired
	private IAttendeeService attendeeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Attendee> findAll() {
		return attendeeService.getAttendees();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid final Attendee attendee) {
		attendeeService.create(attendee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	// TODO PATCH + company as second parameter
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") final long id, @RequestBody @Valid final Attendee attendee) {
		attendeeService.updateCompany(id, attendee.getCompany());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") final long id) {
		attendeeService.delete(id);
	}

}
