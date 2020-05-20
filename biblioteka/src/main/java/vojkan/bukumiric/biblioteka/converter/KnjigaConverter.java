package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.KnjigaDto;
import vojkan.bukumiric.biblioteka.entity.Knjiga;

@Component
public class KnjigaConverter {

	private final ZanrConverter zanrConverter;
	private final AutorConverter autorConverter;

	@Autowired
	public KnjigaConverter(ZanrConverter zanrConverter, AutorConverter autorConverter) {
		this.zanrConverter = zanrConverter;
		this.autorConverter = autorConverter;
	}

	public KnjigaDto entityToDto(Knjiga knjiga) {
		return new KnjigaDto(knjiga.getId(), knjiga.getNaziv(), zanrConverter.entityToDto(knjiga.getZanr()),
				autorConverter.entityToDto(knjiga.getAutor()), knjiga.getBrojStrana());
	}

	public Knjiga dtoToEntity(KnjigaDto knjigaDto) {
		return new Knjiga(knjigaDto.getId(), knjigaDto.getNaziv(), zanrConverter.dtoToEntity(knjigaDto.getZanrDto()),
				autorConverter.dtoToEntity(knjigaDto.getAutorDto()), knjigaDto.getBrojStrana());
	}
	public List<KnjigaDto> convertEntityListToDtoList(List<Knjiga> entityList) {
		List<KnjigaDto> knjigeDtoList = new ArrayList<KnjigaDto>();
		for (Knjiga knjiga : entityList) {
			knjigeDtoList.add(entityToDto(knjiga));

		}
		return knjigeDtoList;
	}
	public List<Knjiga> convertDtoListToEntityList(List<KnjigaDto> dtoList) {
		List<Knjiga> knjigeEntityList = new ArrayList<Knjiga>();
		for (KnjigaDto knjigaDto : dtoList) {
			knjigeEntityList.add(dtoToEntity(knjigaDto));
		}
		return knjigeEntityList;
	}

}
