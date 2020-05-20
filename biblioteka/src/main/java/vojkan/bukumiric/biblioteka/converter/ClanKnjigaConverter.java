package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.ClanKnjigaDto;
import vojkan.bukumiric.biblioteka.entity.ClanKnjiga;

@Component
public class ClanKnjigaConverter {

	private final ClanConverter clanConverter;
	private final KnjigaConverter knjigaConverter;

	@Autowired
	public ClanKnjigaConverter(ClanConverter clanConverter, KnjigaConverter knjigaConverter) {
		this.clanConverter = clanConverter;
		this.knjigaConverter = knjigaConverter;
	}

	public ClanKnjigaDto entityToDto(ClanKnjiga clanKnjiga) {
		return new ClanKnjigaDto(clanKnjiga.getId(), clanConverter.entityToDto(clanKnjiga.getClan()),
				knjigaConverter.entityToDto(clanKnjiga.getKnjiga()));
	}

	public ClanKnjiga dtoToEntity(ClanKnjigaDto clanKnjigaDto) {
		return new ClanKnjiga(clanKnjigaDto.getId(), clanConverter.dtoToEntity(clanKnjigaDto.getClanDto()),
				knjigaConverter.dtoToEntity(clanKnjigaDto.getKnjigaDto()));
	}
	public List<ClanKnjiga> convertDtoListToEntityList(List<ClanKnjigaDto> dtoList) {
		List<ClanKnjiga> clanKnjigaEntityList = new ArrayList<ClanKnjiga>();
		for (ClanKnjigaDto clanKnjigaDto : dtoList) {
			clanKnjigaEntityList.add(dtoToEntity(clanKnjigaDto));
		}

		return clanKnjigaEntityList;
	}
	
	public List<ClanKnjigaDto> convertEntityListToDtoList(List<ClanKnjiga> entityList) {
		List<ClanKnjigaDto> clanKnjigaDtoList = new ArrayList<ClanKnjigaDto>();
		for (ClanKnjiga clanKnjiga : entityList) {
			clanKnjigaDtoList.add(entityToDto(clanKnjiga));
		}
		return clanKnjigaDtoList;
	}

}
