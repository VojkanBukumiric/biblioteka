package vojkan.bukumiric.biblioteka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zanr")
public class Zanr implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "vrsta", length = 30, nullable =  false)
	private String vrsta;

	public Zanr() {

	}

	public Zanr(Long id, String vrsta) {
		super();
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
		return "Zanr [id=" + id + ", vrsta=" + vrsta + "]";
	}

}
