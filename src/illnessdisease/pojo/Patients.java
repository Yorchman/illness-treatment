package illnessdisease.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
@Entity
@Table(name="patients")
public class Patients implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 684614080729457774L;
//Implement serializable, import, rishtclick
	 @Id
     @GeneratedValue(generator="patients")
     @TableGenerator(name="patients", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq", pkColumnValue="patients")
	private Integer id;
	private Integer SSN;
	private String name;
	private Date DOB;
	private String gender;
	private byte[] photo;
	private String password;
	@ManyToMany
	@JoinTable(name="patients-illness",
		joinColumns={@JoinColumn(name="patients_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="illnesses_id", referencedColumnName="id")})
	private List<Illnesses> illnesses;
	@ManyToMany
	@JoinTable(name="patients-symptoms",
		joinColumns={@JoinColumn(name="patients_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="symptoms_id", referencedColumnName="id")})
	private List<Symptoms> symptoms;
	public List<Illnesses> getIllnesses() {
		return illnesses;
	}


	public void setIllnesses(List<Illnesses> illnesses) {
		this.illnesses = illnesses;
	}


	public List<Symptoms> getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(List<Symptoms> symptoms) {
		this.symptoms = symptoms;
	}


	public List<Medicines> getMedicines() {
		return medicines;
	}


	public void setMedicines(List<Medicines> medicines) {
		this.medicines = medicines;
	}


	public List<Intolerance> getIntelorance() {
		return intelorance;
	}


	public void setIntelorance(List<Intolerance> intelorance) {
		this.intelorance = intelorance;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@ManyToMany
	@JoinTable(name="patients-medicines",
		joinColumns={@JoinColumn(name="patients_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="medicines_id", referencedColumnName="id")})
	private List<Medicines> medicines;
	@ManyToMany
	@JoinTable(name="patients-intolerance",
		joinColumns={@JoinColumn(name="patients_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="intolerance_id", referencedColumnName="id")})
	private List<Intolerance> intelorance;
	public Patients() {
		super();
		this.illnesses = new ArrayList<Illnesses>();
		this.symptoms = new ArrayList<Symptoms>();
		this.medicines = new ArrayList<Medicines>();
		this.intelorance=new  ArrayList<Intolerance>();
	}
		
	
	public Patients(Integer id, Integer SSN, String name, Date DOB, String gender, byte[] photo , String password) {
		super();
		this.id = id;
		this.SSN = SSN;
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.photo= photo;
		this.password=password;
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
	public void setSSN(Integer SSN) {
		SSN = SSN;
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
	public void setDOB(Date DOB) {
		DOB = DOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
