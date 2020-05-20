package vojkan.bukumiric.biblioteka.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class KnjigaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@Length(min = 5, message = "Naziv mora da sadrzi minimum pet karaktera")
	@NotNull(message = "Naziv mora da sadrzi minimum pet karaktera")
	private String naziv;
	@NotNull(message = "Molimo vas izaberite zanr")
	private ZanrDto zanrDto;
	@NotNull(message = "Molimo vas izaberite autora")
	private AutorDto autorDto;
	private int brojStrana;
	
	public KnjigaDto() {
		
	}

	public KnjigaDto(Long id, String naziv, ZanrDto zanrDto, AutorDto autorDto, int brojStrana) {
		this.id = id;
		this.naziv = naziv;
		this.zanrDto = zanrDto;
		this.autorDto = autorDto;
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

	public ZanrDto getZanrDto() {
		return zanrDto;
	}

	public void setZanrDto(ZanrDto zanrDto) {
		this.zanrDto = zanrDto;
	}

	public AutorDto getAutorDto() {
		return autorDto;
	}

	public void setAutorDto(AutorDto autorDto) {
		this.autorDto = autorDto;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	@Override
	public String toString() {
		return "KnjigaDto [id=" + id + ", naziv=" + naziv + ", zanrDto=" + zanrDto + ", autorDto=" + autorDto
				+ ", brojStrana=" + brojStrana + "]";
	}
	
	

}
