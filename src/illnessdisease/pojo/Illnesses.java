package illnessdisease.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;



@Entity
@Table(name="illnesses")
public class Illnesses implements Serializable{

	
	
	private static final long serialVersionUID = -4120176035031838818L;

     @Id
     @GeneratedValue(generator="illnesses")
     @TableGenerator(name="illnesses", table="sqlite_sequence",
pkColumnName="name", valueColumnName="seq", pkColumnValue="illnesses")
private Integer id;
private String name;
private String type;
private String causes;
private boolean contagious;
@ManyToMany(mappedBy = "illnesses")
private List<Patients> patients;
@ManyToMany
@JoinTable(name="illness-disease",
	joinColumns={@JoinColumn(name="illness_id", referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="symptoms_id", referencedColumnName="id")})
private List<Symptoms> symptoms;
@ManyToMany(mappedBy = "illnesses")
private List<Medicines> medicines;

public Illnesses() {
	super();
	this.patients = new ArrayList<Patients>();
	this.symptoms = new ArrayList<Symptoms>();
	this.medicines = new ArrayList<Medicines>();
}

public Illnesses(Integer id, String name, String type, String causes, boolean contagious) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.causes = causes;
	this.contagious = contagious;
	this.patients = new ArrayList<Patients>();
	this.symptoms = new ArrayList<Symptoms>();
	this.medicines = new ArrayList<Medicines>();
}

public Illnesses (String name, String type, String causes, boolean contagious) {
	super();
	this.name = name;
	this.type = type;
	this.causes = causes;
	this.contagious = contagious;
	this.patients = new ArrayList<Patients>();
	this.symptoms = new ArrayList<Symptoms>();
	this.medicines = new ArrayList<Medicines>();
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
	Illnesses other = (Illnesses) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}



@Override
public String toString() {
	return "Illnesses [id=" + id + ", name=" + name + ", type=" + type + ", causes=" + causes + ", contagious="
			+ contagious + ", patients=" + patients + ", symptoms=" + symptoms + ", medicines=" + medicines + "]";
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public boolean isContagious() {
	return contagious;
}
public void setContagious(boolean contagious) {
	this.contagious = contagious;
}
public String getCauses() {
	return causes;
}
public void setCauses(String causes) {
	this.causes = causes;
}
public List<Patients> getPatients() {
	return patients;
}
public void setPatients(List<Patients> patients) {
	this.patients = patients;
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

}
