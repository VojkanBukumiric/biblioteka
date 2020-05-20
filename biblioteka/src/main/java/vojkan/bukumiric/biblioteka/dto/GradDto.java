package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;

public class GradDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String naziv;

	public GradDto() {

	}

	public GradDto(Long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "GradDto [id=" + id + ", naziv=" + naziv + "]";
	}

}
