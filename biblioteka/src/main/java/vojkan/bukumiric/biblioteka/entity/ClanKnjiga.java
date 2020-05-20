package vojkan.bukumiric.biblioteka.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clan_knjiga")
public class ClanKnjiga implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Clan_id",referencedColumnName = "id", nullable = false)
	private Clan clan;
	@ManyToOne
	@JoinColumn(name = "Knjiga_id",referencedColumnName = "id", nullable = false)
	private Knjiga knjiga;
	
	public ClanKnjiga() {
		
	}

	public ClanKnjiga(Long id, Clan clan, Knjiga knjiga) {
		this.id = id;
		this.clan = clan;
		this.knjiga = knjiga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	@Override
	public String toString() {
		return "ClanKnjiga [id=" + id + ", clan=" + clan + ", knjiga=" + knjiga + "]";
	}
	
	

}
