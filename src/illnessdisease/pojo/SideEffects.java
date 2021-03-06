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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
@Entity
@Table(name="sideEffects")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SideEffect")
@XmlType(propOrder = { "name", "duration", "area" })
public class SideEffects implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7586405773185099824L;
	@Id
    @GeneratedValue(generator="sideEffects")
    @TableGenerator(name="sideEffects", table="sqlite_sequence",

       pkColumnName="name", valueColumnName="seq", pkColumnValue="sideEffects")
	@XmlTransient
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private Integer duration;
	@XmlElement
	private String area;
	@ManyToMany(mappedBy = "sideEffects")
	@XmlTransient
	private List<Medicines> medicines;
	
	public List<Medicines> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicines> medicines) {
		this.medicines = medicines;
	}
	public SideEffects() {
		super();
		this.medicines = new ArrayList<Medicines>();
	}
	public SideEffects(Integer id, String name, Integer duration, String area) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.area = area;
		this.medicines = new ArrayList<Medicines>();
	}
	
	public SideEffects(String name, Integer duration, String area) {
		super();
		this.name = name;
		this.duration = duration;
		this.area = area;
		this.medicines = new ArrayList<Medicines>();
	}
	
	public void addMedicine(Medicines medicine){
		medicines.add(medicine);
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
		SideEffects other = (SideEffects) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
