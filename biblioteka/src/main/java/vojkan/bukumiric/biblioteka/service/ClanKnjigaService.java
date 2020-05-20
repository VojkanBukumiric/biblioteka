package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.ClanKnjigaDto;

public interface ClanKnjigaService {
	
	public void save (ClanKnjigaDto clanKnjigaDto);
	public List<ClanKnjigaDto>findAll();
	
}
