package illnessdisease.pojo;
import java.io.Serializable;
public class Medicines implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5110084765037796663L;
	private Integer id;
	private String name;
	private String activePrinciple;
	private String restrictions;
	private Double price;
	private Boolean seguridadSocial;
	public Medicines() {
		super();
	}
	public Medicines(Integer id, String name, String activePrinciple, String restrictions, Double price,
			boolean seguridadSocial) {
		super();
		this.id = id;
		this.name = name;
		this.activePrinciple = activePrinciple;
		this.restrictions = restrictions;
		this.price = price;
		this.seguridadSocial = seguridadSocial;
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
	public String getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
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
