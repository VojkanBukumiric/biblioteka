package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.GradDto;

public interface GradService {
	
	public void save(GradDto gradDto);
	public List<GradDto>findAll();
	public GradDto findById(Long id);

}
