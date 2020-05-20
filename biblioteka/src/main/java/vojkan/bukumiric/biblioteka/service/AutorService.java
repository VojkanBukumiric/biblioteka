package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.AutorDto;

public interface AutorService {
	
	public void save(AutorDto autorDto);
	public List<AutorDto>findAll();
	public AutorDto findById(Long id);
	public void deleteById(Long id);

}
