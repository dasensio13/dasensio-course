package dasensio.java.course.web.atendee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dasensio.java.course.domain.atendee.Atendee;
import dasensio.java.course.service.atendee.IAtendeeService;

@RestController
@RequestMapping(value = "rest/atendee")
public class AtendeeRestController {

	@Autowired
	private IAtendeeService atendeeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Atendee> findAll(final HttpServletRequest request, final UriComponentsBuilder uriBuilder,
			final HttpServletResponse response) {
		return atendeeService.getAtendees();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid final Atendee atendee, final UriComponentsBuilder uriBuilder,
			final HttpServletResponse response) {
		atendeeService.create(atendee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	// TODO: PATCH + company as second parameter
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") final long id, @RequestBody @Valid final Atendee atendee) {
		atendeeService.updateCompany(id, atendee.getCompany());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") final long id) {
		atendeeService.delete(id);
	}

}
