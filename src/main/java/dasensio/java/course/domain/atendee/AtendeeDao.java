package dasensio.java.course.domain.atendee;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import dasensio.java.course.domain.AbstractJpaDAO;

@Repository("atendeeDao")
public class AtendeeDao extends AbstractJpaDAO<Atendee> implements IAtendeeDao, Serializable {

	private static final long serialVersionUID = 7852853985269242888L;

	public AtendeeDao() {
		setClazz(Atendee.class);
	}

}
