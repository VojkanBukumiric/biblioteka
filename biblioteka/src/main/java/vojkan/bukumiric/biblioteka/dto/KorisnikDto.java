package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class KorisnikDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Molimo vas unesite korisnicko ime")
	private String ime;
	@NotNull(message = "Molimo vas unesite lozinku")
	private String lozinka;
	
	public KorisnikDto() {
		
	}
	
	public KorisnikDto(Long id, String ime, String lozinka) {
		this.id = id;
		this.ime = ime;
		this.lozinka = lozinka;
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

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "KorisnikDto [id=" + id + ", ime=" + ime + ", lozinka=" + lozinka + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((lozinka == null) ? 0 : lozinka.hashCode());
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
		KorisnikDto other = (KorisnikDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (lozinka == null) {
			if (other.lozinka != null)
				return false;
		} else if (!lozinka.equals(other.lozinka))
			return false;
		return true;
	}
	
	
	

}
