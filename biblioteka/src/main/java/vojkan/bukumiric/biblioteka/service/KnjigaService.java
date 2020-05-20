package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.KnjigaDto;

public interface KnjigaService {
	
	public void save(KnjigaDto knjigaDto);
	public List<KnjigaDto>findAll();
	public KnjigaDto findById(Long id);
	public void deleteById(Long id);

}
