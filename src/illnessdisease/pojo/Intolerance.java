package illnessdisease.pojo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Intolerance  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2144251766134435470L;

	private Integer id;
	private String name;
	private List<Patients> patients;
	public Intolerance() {
		super();
		this.patients = new ArrayList<Patients>();
	}
	public Intolerance(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.patients = new ArrayList<Patients>();
		
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
		Intolerance other = (Intolerance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
