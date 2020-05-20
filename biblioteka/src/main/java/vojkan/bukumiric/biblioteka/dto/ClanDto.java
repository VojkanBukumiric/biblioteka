package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class ClanDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Molimo vas unesite ime")
	private String ime;
	@NotNull(message = "Molimo vas unesite prezime")
	private String prezime;
	@NotNull(message = "Molimo vas unesite grad")
	private GradDto gradDto;
	@NotNull(message = "Molimo vas unesite adresu")
	private String adresa;
	@NotNull(message = "Molimo vas unesite email")
	private String email;
	@NotNull
	private String brClanskeKarte;
	@NotNull
	private Date pocetakPretplate;
	@NotNull
	private Date krajPretplate;
	
	public ClanDto() {
		
	}

	

	public ClanDto(Long id, String ime, String prezime, GradDto gradDto, String adresa, String email,
			String brClanskeKarte, Date pocetakPretplate, Date krajPretplate) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.gradDto = gradDto;
		this.adresa = adresa;
		this.email = email;
		this.brClanskeKarte = brClanskeKarte;
		this.pocetakPretplate = pocetakPretplate;
		this.krajPretplate = krajPretplate;
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

	public GradDto getGradDto() {
		return gradDto;
	}

	public void setGradDto(GradDto gradDto) {
		this.gradDto = gradDto;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrClanskeKarte() {
		return brClanskeKarte;
	}

	public void setBrClanskeKarte(String brClanskeKarte) {
		this.brClanskeKarte = brClanskeKarte;
	}

	public Date getPocetakPretplate() {
		return pocetakPretplate;
	}

	public void setPocetakPretplate(Date pocetakPretplate) {
		this.pocetakPretplate = pocetakPretplate;
	}

	public Date getKrajPretplate() {
		return krajPretplate;
	}

	public void setKrajPretplate(Date krajPretplate) {
		this.krajPretplate = krajPretplate;
	}
	public String getImeIPrezime() {
		return ime + " " + prezime;
	}

	@Override
	public String toString() {
		return "ClanDto [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", gradDto=" + gradDto + ", adresa="
				+ adresa + ", mail=" + email + ", brClanskeKarte=" + brClanskeKarte + ", pocetakPretplate="
				+ pocetakPretplate + ", krajPretplate=" + krajPretplate + "]";
	}
	
	

}
