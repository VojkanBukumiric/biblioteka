package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.ClanDto;
import vojkan.bukumiric.biblioteka.entity.Clan;

@Component
public class ClanConverter {

	private final GradConverter gradConverter;

	@Autowired
	public ClanConverter(GradConverter gradConverter) {
		this.gradConverter = gradConverter;
	}

	public ClanDto entityToDto(Clan clan) {

		return new ClanDto(clan.getId(), clan.getIme(), clan.getPrezime(), gradConverter.entityToDto(clan.getGrad()),
				clan.getAdresa(), clan.getEmail(), clan.getBrClanskeKarte(), clan.getPocetakPretplate(),
				clan.getKrajPretplate());
	}

	public Clan dtoToEntity(ClanDto clanDto) {

		return new Clan(clanDto.getId(), clanDto.getIme(), clanDto.getPrezime(),
				gradConverter.dtoToEntity(clanDto.getGradDto()), clanDto.getAdresa(), clanDto.getEmail(),
				clanDto.getBrClanskeKarte(), clanDto.getPocetakPretplate(), clanDto.getKrajPretplate());
	}

	public List<ClanDto> convertEntityListToDtoList(List<Clan> entityList) {
		List<ClanDto> clanoviDtoList = new ArrayList<ClanDto>();
		for (Clan clan : entityList) {
			clanoviDtoList.add(entityToDto(clan));
		}
		return clanoviDtoList;
	}

	public List<Clan> convertDtoListToEntityList(List<ClanDto> dtoList) {
		List<Clan> clanoviEntityList = new ArrayList<Clan>();
		for (ClanDto clanDto : dtoList) {
			clanoviEntityList.add(dtoToEntity(clanDto));
		}
		return clanoviEntityList;
	}

}
