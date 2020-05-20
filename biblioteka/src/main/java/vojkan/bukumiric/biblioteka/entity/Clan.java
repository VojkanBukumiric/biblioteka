package vojkan.bukumiric.biblioteka.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clan")
public class Clan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ime", length = 3, nullable = false)
	private String ime;
	@Column(name = "prezime", length = 3, nullable = false)
	private String prezime;
	@ManyToOne
	@JoinColumn(name = "grad_id", referencedColumnName = "id")
	private Grad grad;
	@Column(name = "adresa", length = 30, nullable = false)
	private String adresa;
	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "brClanskeKarte", length = 8)
	private String brClanskeKarte;
	@Temporal(TemporalType.DATE)
	@Column(name = "pocetakPretplate", nullable = false)
	private Date pocetakPretplate;
	@Temporal(TemporalType.DATE)
	@Column(name = "krajPretplate", nullable = false)
	private Date krajPretplate;

	public Clan() {

	}

	public Clan(Long id, String ime, String prezime, Grad grad, String adresa, String email, String brClanskeKarte,
			Date pocetakPretplate, Date krajPretplate) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.grad = grad;
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

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
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

	@Override
	public String toString() {
		return "Clan [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", grad=" + grad + ", adresa=" + adresa
				+ ", email=" + email + ", brClanskeKarte=" + brClanskeKarte + ", pocetakPretplate=" + pocetakPretplate
				+ ", krajPretplate=" + krajPretplate + "]";
	}

}
