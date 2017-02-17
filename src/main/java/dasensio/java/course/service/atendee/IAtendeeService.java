package dasensio.java.course.service.atendee;

import java.util.List;

import dasensio.java.course.domain.atendee.Atendee;

public interface IAtendeeService {

	void create(Atendee atendee);

	List<Atendee> getAtendees();

	Atendee getAtendee(long idAtendee);

	void delete(long idAtendee);

	Atendee updateCompany(long idAtendee, String company);
}
