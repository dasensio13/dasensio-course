package dasensio.java.course.service.attendee;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import dasensio.java.course.domain.attendee.Attendee;
import dasensio.java.course.domain.attendee.IAttendeeDao;

@Service("attendeeService")
@Transactional
public class AttendeeService implements IAttendeeService, Serializable {

	private static final long serialVersionUID = 7174755465560585371L;

	@Autowired
	private IAttendeeDao attendeeDao;

	@Override
	public List<Attendee> getAttendees() {
		return attendeeDao.findAll();
	}

	@Override
	public Attendee getAttendee(final long idAttendee) {
		return attendeeDao.findOne(idAttendee);
	}

	@Override
	public void create(final Attendee attendee) {
		Assert.hasText(attendee.getName());
		// TODO validate the attendee is not already in the DDBB
		attendeeDao.create(attendee);
	}

	@Override
	public void delete(final long idAttendee) {
		attendeeDao.deleteById(idAttendee);
	}

	@Override
	public Attendee updateCompany(final long idAttendee, final String company) {
		final Attendee attendee = attendeeDao.findOne(idAttendee);
		Assert.notNull(attendee);
		attendee.setCompany(company);
		return attendeeDao.update(attendee);
	}

}
