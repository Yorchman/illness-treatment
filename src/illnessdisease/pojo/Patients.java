package illnessdisease.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Patients implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 684614080729457774L;
//Implement serializable, import, rishtclick

	private Integer id;
	private String name;
	private Date DOB;
	private String gender;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patients other = (Patients) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Patients(Integer id, String name, Date dOB, String gender) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.gender = gender;
	}

	public Patients() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

		

	}
