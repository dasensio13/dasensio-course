package dasensio.java.course.domain.attendee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Attendee implements Serializable {

	private static final long serialVersionUID = 763751646466760435L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME", nullable = false)
	@NotNull
	private String name;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "COMPANY")
	private String company;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(final String company) {
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

}
