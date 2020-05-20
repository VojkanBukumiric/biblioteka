package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import vojkan.bukumiric.biblioteka.enums.KnjizevnaVrsta;

public class AutorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@Length(min = 3, message = "Ime mora da sadrzi minimum tri karaktera")
	@NotNull(message = "Ime mora da sadrzi minimum tri karaktera")
	private String ime;
	@Length(min = 3, message = "Prezime mora da sadrzi minimum tri karaktera")
	@NotNull(message = "Prezime mora da sadrzi minimum tri slova")
	private String prezime;
	@NotNull(message = "molimo vas odaberite knjizevnu vrstu")
	private KnjizevnaVrsta knjizevnaVrsta;

	public AutorDto() {

	}

	public AutorDto(Long id, String ime, String prezime, KnjizevnaVrsta knjizevnaVrsta) {
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

	public String getImeIPrezime() {
		return ime + " " + prezime;
	}

	@Override
	public String toString() {
		return "AutorDto [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", knjizevnaVrsta=" + knjizevnaVrsta
				+ "]";
	}

}
