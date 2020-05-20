package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;

public class ZanrDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String vrsta;

	public ZanrDto() {

	}

	public ZanrDto(Long id, String vrsta) {
		this.id = id;
		this.vrsta = vrsta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	@Override
	public String toString() {
		return "ZanrDto [id=" + id + ", vrsta=" + vrsta + "]";
	}

}
