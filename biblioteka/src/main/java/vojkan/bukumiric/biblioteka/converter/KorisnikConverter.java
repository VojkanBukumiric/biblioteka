package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.KorisnikDto;
import vojkan.bukumiric.biblioteka.entity.Korisnik;

@Component
public class KorisnikConverter {

	public KorisnikDto entityToDto(Korisnik korisnik) {
		return new KorisnikDto(korisnik.getId(), korisnik.getIme(), korisnik.getLozinka());
	}

	public Korisnik dtoToEntity(KorisnikDto korisnikDto) {
		return new Korisnik(korisnikDto.getId(), korisnikDto.getIme(), korisnikDto.getLozinka());
	}

	public List<KorisnikDto> convertEntityListToDtoList(List<Korisnik> entityList) {

		List<KorisnikDto> korisniciDtoList = new ArrayList<KorisnikDto>();
		for (Korisnik korisnik : entityList) {
			korisniciDtoList.add(entityToDto(korisnik));
		}
		return korisniciDtoList;
	}

	public List<Korisnik> convertDtoListToEntityList(List<KorisnikDto> dtoList) {

		List<Korisnik> korisniciDtoList = new ArrayList<Korisnik>();
		for (KorisnikDto korisnikDto : dtoList) {
			korisniciDtoList.add(dtoToEntity(korisnikDto));
		}
		return korisniciDtoList;
	}

}
