package vojkan.bukumiric.biblioteka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "knjiga")
public class Knjiga implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "naziv", length = 80, nullable = false)
	private String naziv;
	@ManyToOne
	@JoinColumn(name = "zanr_id", referencedColumnName = "id", nullable = false)
	private Zanr zanr;
	@ManyToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "id", nullable = false)
	private Autor autor;
	@Column(name = "brojStrana", nullable = false)
	private int brojStrana;

	public Knjiga() {

	}

	public Knjiga(Long id, String naziv, Zanr zanr, Autor autor, int brojStrana) {
		this.id = id;
		this.naziv = naziv;
		this.zanr = zanr;
		this.autor = autor;
		this.brojStrana = brojStrana;
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

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naziv=" + naziv + ", zanr=" + zanr + ", autor=" + autor + ", brojStrana="
				+ brojStrana + "]";
	}

}
