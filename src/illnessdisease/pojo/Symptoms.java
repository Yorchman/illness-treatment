package illnessdisease.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="symptoms")
public class Symptoms  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1958374975214628570L;
	 @Id
     @GeneratedValue(generator="symptoms")
     @TableGenerator(name="symptoms", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq", pkColumnValue="symptoms")
	private Integer id;
	private String name;
	private String Diagnosis;
	private String Areas;
	private Integer Duration;
	@ManyToMany(mappedBy = "patients-symptoms")
	private List<Patients> patients;
	@ManyToMany(mappedBy = "illness-disease")
	private List<Illnesses> illnesses;
	public Symptoms() {
		super();
		this.illnesses = new ArrayList<Illnesses>();
		this.patients= new ArrayList<Patients>();
	}
	public List<Patients> getPatients() {
		return patients;
	}
	public void setPatients(List<Patients> patients) {
		this.patients = patients;
	}
	public List<Illnesses> getIllnesses() {
		return illnesses;
	}
	public void setIllnesses(List<Illnesses> illnesses) {
		this.illnesses = illnesses;
	}
	public Symptoms(Integer id, String name, String diagnosis, String areas, Integer duration) {
		super();
		this.id = id;
		this.name = name;
		Diagnosis = diagnosis;
		Areas = areas;
		Duration = duration;
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
	public String getDiagnosis() {
		return Diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}
	public String getAreas() {
		return Areas;
	}
	public void setAreas(String areas) {
		Areas = areas;
	}
	public Integer getDuration() {
		return Duration;
	}
	public void setDuration(Integer duration) {
		Duration = duration;
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
		Symptoms other = (Symptoms) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}