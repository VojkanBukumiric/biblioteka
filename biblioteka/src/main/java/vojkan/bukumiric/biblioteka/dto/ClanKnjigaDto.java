package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ClanKnjigaDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "morate da odaberete clana")
	private ClanDto clanDto;
	@NotNull(message = "morate da odaberete knjigu")
	private KnjigaDto knjigaDto;
	
	public ClanKnjigaDto() {
		
	}

	public ClanKnjigaDto(Long id, ClanDto clanDto, KnjigaDto knjigaDto) {
		this.id = id;
		this.clanDto = clanDto;
		this.knjigaDto = knjigaDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClanDto getClanDto() {
		return clanDto;
	}

	public void setClanDto(ClanDto clanDto) {
		this.clanDto = clanDto;
	}

	public KnjigaDto getKnjigaDto() {
		return knjigaDto;
	}

	public void setKnjigaDto(KnjigaDto knjigaDto) {
		this.knjigaDto = knjigaDto;
	}

	@Override
	public String toString() {
		return "ClanKnjigaDto [id=" + id + ", clanDto=" + clanDto + ", knjigaDto=" + knjigaDto + "]";
	}
	
	
	

}
