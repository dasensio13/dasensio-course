package dasensio.java.course.service.atendee;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import dasensio.java.course.domain.atendee.Atendee;
import dasensio.java.course.domain.atendee.IAtendeeDao;

@Service("atendeeService")
@Transactional
public class AtendeeService implements IAtendeeService, Serializable {

	private static final long serialVersionUID = 7174755465560585371L;

	@Autowired
	private IAtendeeDao atendeeDao;

	@Override
	public List<Atendee> getAtendees() {
		return atendeeDao.findAll();
	}

	@Override
	public Atendee getAtendee(final long idAtendee) {
		return atendeeDao.findOne(idAtendee);
	}

	@Override
	public void create(final Atendee atendee) {
		Assert.hasText(atendee.getName());
		// TODO validate the atendee is not already in the DDBB
		atendeeDao.create(atendee);
	}

	@Override
	public void delete(final long idAtendee) {
		atendeeDao.deleteById(idAtendee);
	}

	@Override
	public Atendee updateCompany(final long idAtendee, final String company) {
		final Atendee atendee = atendeeDao.findOne(idAtendee);
		Assert.notNull(atendee);
		atendee.setCompany(company);
		return atendeeDao.update(atendee);
	}

}
