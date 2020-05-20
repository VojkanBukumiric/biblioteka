package vojkan.bukumiric.biblioteka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import vojkan.bukumiric.biblioteka.enums.KnjizevnaVrsta;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ime", length = 60, nullable = false)
	private String ime;
	@Column(name = "prezime", length = 60, nullable = false)
	private String prezime;
	@Column(name = "knjizevnaVrsta", length = 20)
	private KnjizevnaVrsta knjizevnaVrsta;

	public Autor() {

	}

	public Autor(Long id, String ime, String prezime, KnjizevnaVrsta knjizevnaVrsta) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.knjizevnaVrsta = knjizevnaVrsta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public KnjizevnaVrsta getKnjizevnaVrsta() {
		return knjizevnaVrsta;
	}

	public void setKnjizevnaVrsta(KnjizevnaVrsta knjizevnaVrsta) {
		this.knjizevnaVrsta = knjizevnaVrsta;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", knjizevnaVrsta=" + knjizevnaVrsta + "]";
	}

}
