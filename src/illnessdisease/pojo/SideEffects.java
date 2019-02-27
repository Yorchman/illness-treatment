package illnessdisease.pojo;
import java.io.Serializable;

public class SideEffects implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7586405773185099824L;

	private Integer id;
	private String name;
	private Integer duration;
	private String area;
	public SideEffects() {
		super();
	}
	public SideEffects(Integer id, String name, Integer duration, String area) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.area = area;
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
