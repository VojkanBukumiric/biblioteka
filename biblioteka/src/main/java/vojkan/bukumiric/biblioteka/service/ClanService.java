package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.ClanDto;

public interface ClanService {
	
	public void save (ClanDto clanDto);
	public List<ClanDto>findAll();
	public ClanDto findById(Long id);
	public void deleteById(Long id);
	public List<ClanDto> findByBrClanskeKarte(ClanDto clanDto);

}
