package illnessdisease.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Illnesses implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4120176035031838818L;

private Integer id;
private String name;
private String type;
private String causes;
private boolean contagious;
private List<Patients> patients;
private List<Symptoms> symptoms;
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

}
