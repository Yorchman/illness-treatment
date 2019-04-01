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
@Entity
@Table(name="medicines")
public class Medicines implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5110084765037796663L;
	 @Id
     @GeneratedValue(generator="medicines")
     @TableGenerator(name="medicines", table="sqlite_sequence",
        pkColumnName="name", valueColumnName="seq", pkColumnValue="medicines")
	private Integer id;
	private String name;
	private String activePrinciple;
	private Double price;
	private Boolean seguridadSocial;
	@ManyToMany(mappedBy = "patients-medicines")
	private List<Patients> patients;
	@ManyToMany
	@JoinTable(name="medicines-sideEffects",
		joinColumns={@JoinColumn(name="medicines_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="sideEffects_id", referencedColumnName="id")})
	private List<SideEffects> sideEffects;
	@ManyToMany
	@JoinTable(name="medicines-illness",
		joinColumns={@JoinColumn(name="medicines_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="illnesses_id", referencedColumnName="id")})
	private List<Illnesses> illnesses ;
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
		this.seguridadSocial = seguridadSocial;
		this.patients = new ArrayList<Patients>();
		this.sideEffects = new ArrayList<SideEffects>();
		this.illnesses = new ArrayList<Illnesses>();
	
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
		return seguridadSocial;
	}
	public void setSeguridadSocial(Boolean seguridadSocial) {
		this.seguridadSocial = seguridadSocial;
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
