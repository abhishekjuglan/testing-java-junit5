package guru.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity {
	private String description;

	public Speciality() {
	}

	public Speciality(String description) {
		this.description = description;
	}

	public Speciality(Long id, String description) {
		super(id);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj != null && obj instanceof Speciality && ((Speciality) obj).description.equals(this.description))
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Long(this.getId()).intValue();
	}
}
