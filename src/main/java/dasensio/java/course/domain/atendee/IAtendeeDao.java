package dasensio.java.course.domain.atendee;

import java.util.List;

public interface IAtendeeDao {

	Atendee findOne(long idAtendee);

	List<Atendee> findAll();

	void create(Atendee atendee);

	Atendee update(Atendee atendee);

	void delete(Atendee atendee);

	void deleteById(long idAtendee);
}
