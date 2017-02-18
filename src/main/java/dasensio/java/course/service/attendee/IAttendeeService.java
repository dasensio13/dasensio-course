package dasensio.java.course.service.attendee;

import java.util.List;

import dasensio.java.course.domain.attendee.Attendee;

public interface IAttendeeService {

	void create(Attendee attendee);

	List<Attendee> getAttendees();

	Attendee getAttendee(long idAttendee);

	void delete(long idAttendee);

	Attendee updateCompany(long idAttendee, String company);
}
