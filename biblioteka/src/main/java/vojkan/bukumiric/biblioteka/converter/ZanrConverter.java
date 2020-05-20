package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.ZanrDto;
import vojkan.bukumiric.biblioteka.entity.Zanr;

@Component
public class ZanrConverter {

	public ZanrDto entityToDto(Zanr zanr) {
		return new ZanrDto(zanr.getId(), zanr.getVrsta());
	}

	public Zanr dtoToEntity(ZanrDto zanrDto) {
		return new Zanr(zanrDto.getId(), zanrDto.getVrsta());
	}

	public List<ZanrDto> convertEntityListToDtoList(List<Zanr> entityList) {
		List<ZanrDto> zanroviDto = new ArrayList<ZanrDto>();
		for (Zanr zanr : entityList) {
			zanroviDto.add(entityToDto(zanr));
		}
		return zanroviDto;
	}

	public List<Zanr> convertDtoListToEntityList(List<ZanrDto> dtoList) {
		List<Zanr> zanrovi = new ArrayList<Zanr>();
		for (ZanrDto zanrDto : dtoList) {
			zanrovi.add(dtoToEntity(zanrDto));
		}
		return zanrovi;
	}

}
