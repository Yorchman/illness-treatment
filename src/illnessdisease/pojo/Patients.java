package illnessdisease.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Patients implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 684614080729457774L;
//Implement serializable, import, rishtclick

	private Integer id;
	private Integer SSN;
	private String name;
	private Date DOB;
	private String gender;
	private List<Illnesses> illnesses;
	private List<Symptoms> symptoms;
	private List<Medicines> medicines;
	private List<Intolerance> intelorance;
	public Patients() {
		super();
		this.illnesses = new ArrayList<Illnesses>();
		this.symptoms = new ArrayList<Symptoms>();
		this.medicines = new ArrayList<Medicines>();
		this.intelorance=new  ArrayList<Intolerance>();
	}
		
	
	public Patients(Integer id, Integer sSN, String name, Date dOB, String gender) {
		super();
		this.id = id;
		SSN = sSN;
		this.name = name;
		DOB = dOB;
		this.gender = gender;
		this.illnesses = new ArrayList<Illnesses>();
		this.symptoms = new ArrayList<Symptoms>();
		this.medicines = new ArrayList<Medicines>();
		this.intelorance=new  ArrayList<Intolerance>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSSN() {
		return SSN;
	}
	public void setSSN(Integer sSN) {
		SSN = sSN;
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
	
	

	}
