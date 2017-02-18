package dasensio.java.course.domain.attendee;

import java.util.List;

public interface IAttendeeDao {

	Attendee findOne(long idAttendee);

	List<Attendee> findAll();

	void create(Attendee attendee);

	Attendee update(Attendee attendee);

	void delete(Attendee attendee);

	void deleteById(long idAttendee);
}
