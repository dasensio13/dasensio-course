package dasensio.java.course.domain.attendee;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import dasensio.java.course.domain.AbstractJpaDAO;

@Repository("attendeeDao")
public class AttendeeDao extends AbstractJpaDAO<Attendee> implements IAttendeeDao, Serializable {

	private static final long serialVersionUID = 7852853985269242888L;

	public AttendeeDao() {
		setClazz(Attendee.class);
	}

}
