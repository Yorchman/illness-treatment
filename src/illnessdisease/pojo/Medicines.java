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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
@Entity
@Table(name="medicines")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Medicine")
@XmlType(propOrder = { "name", "activePrinciple", "price","seguridadSocial","sideEffects" })
public class Medicines implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5110084765037796663L;
	 @Id
     @GeneratedValue(generator="medicines")
     @TableGenerator(name="medicines", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq", pkColumnValue="medicines")
    @XmlAttribute
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlElement
	private String activePrinciple;
	@XmlElement
	private Double price;
	@XmlAttribute
	private Boolean SSCover;
	@ManyToMany(mappedBy = "medicines")
	@XmlTransient
	private List<Patients> patients;
	@ManyToMany
	@JoinTable(name="medicines-sideEffects",
		joinColumns={@JoinColumn(name="medicines_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="sideEffects_id", referencedColumnName="id")})
	@XmlElement(name = "SideEffect")
    @XmlElementWrapper(name = "SideEffects")
	private List<SideEffects> sideEffects;
	@ManyToMany
	@JoinTable(name="medicines-illness",
		joinColumns={@JoinColumn(name="medicines_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="illnesses_id", referencedColumnName="id")})
	@XmlTransient
	private List<Illnesses> illnesses ;
	
	
	public List<Patients> getPatients() {
		return patients;
	}
	public void setPatients(List<Patients> patients) {
		this.patients = patients;
	}
	public List<SideEffects> getSideEffects() {
		return sideEffects;
	}
	public void setSideEffects(List<SideEffects> sideEffects) {
		this.sideEffects = sideEffects;
	}
	public List<Illnesses> getIllnesses() {
		return illnesses;
	}
	public void setIllnesses(List<Illnesses> illnesses) {
		this.illnesses = illnesses;
	}
	public Boolean getSeguridadSocial() {
		return SSCover;
	}
	public Medicines() {
		super();
		this.patients = new ArrayList<Patients>();
		this.sideEffects = new ArrayList<SideEffects>();
		this.illnesses = new ArrayList<Illnesses>();
	}
	public Medicines(Integer id, String name, String activePrinciple, String restrictions, Double price,
			boolean seguridadSocial) {
		super();
		this.id = id;
		this.name = name;
		this.activePrinciple = activePrinciple;
		this.price = price;
		this.SSCover = seguridadSocial;
		this.patients = new ArrayList<Patients>();
		this.sideEffects = new ArrayList<SideEffects>();
		this.illnesses = new ArrayList<Illnesses>();
	
	}
	
	public void addPatient(Patients patient){
		patients.add(patient);
	}
	
	public void addSideEffect(SideEffects sideEffect){
		sideEffects.add(sideEffect);
	}
	
	public void addIllness(Illnesses illness){
		illnesses.add(illness);
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
	public String getActivePrinciple() {
		return activePrinciple;
	}
	public void setActivePrinciple(String activePrinciple) {
		this.activePrinciple = activePrinciple;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isSeguridadSocial() {
		return SSCover;
	}
	public void setSeguridadSocial(Boolean seguridadSocial) {
		this.SSCover = seguridadSocial;
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
		Medicines other = (Medicines) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
