package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.AutorDto;
import vojkan.bukumiric.biblioteka.entity.Autor;

@Component
public class AutorConverter {

	public AutorDto entityToDto(Autor autor) {
		return new AutorDto(autor.getId(), autor.getIme(), autor.getPrezime(), autor.getKnjizevnaVrsta());
	}

	public Autor dtoToEntity(AutorDto autorDto) {
		return new Autor(autorDto.getId(), autorDto.getIme(), autorDto.getPrezime(), autorDto.getKnjizevnaVrsta());
	}

	public List<AutorDto> convertEntityListToDtoList(List<Autor> entityList) {
		List<AutorDto> autoriDtoList = new ArrayList<AutorDto>();
		for (Autor autor : entityList) {
			autoriDtoList.add(entityToDto(autor));
		}
		return autoriDtoList;
	}

	public List<Autor> convertDtoListToEntityList(List<AutorDto> dtoList) {
		List<Autor> autoriEntityList = new ArrayList<Autor>();
		for (AutorDto autorDto : dtoList) {
			autoriEntityList.add(dtoToEntity(autorDto));
		}
		return autoriEntityList;
	}

}
