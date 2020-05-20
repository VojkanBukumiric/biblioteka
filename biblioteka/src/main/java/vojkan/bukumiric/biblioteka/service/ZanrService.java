package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.ZanrDto;

public interface ZanrService {

	public void save(ZanrDto zanrDto);
	public List<ZanrDto> findAll();
	public ZanrDto findById(Long id);

}
