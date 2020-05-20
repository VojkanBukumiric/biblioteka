package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.AutorConverter;
import vojkan.bukumiric.biblioteka.dto.AutorDto;
import vojkan.bukumiric.biblioteka.entity.Autor;
import vojkan.bukumiric.biblioteka.repository.AutorRepository;
import vojkan.bukumiric.biblioteka.service.AutorService;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {

	private AutorRepository autorRepository;
	private AutorConverter autorConverter;

	@Autowired
	public AutorServiceImpl(AutorRepository autorRepository, AutorConverter autorConverter) {
		this.autorRepository = autorRepository;
		this.autorConverter = autorConverter;
	}

	@Override
	public void save(AutorDto autorDto) {
		autorRepository.save(autorConverter.dtoToEntity(autorDto));

	}

	@Override
	public List<AutorDto> findAll() {
		List<Autor> autori = autorRepository.findAll();
		List<AutorDto> autoriDto = autorConverter.convertEntityListToDtoList(autori);
		return autoriDto;
	}

	@Override
	public AutorDto findById(Long id) {
		Optional<Autor> optionalAutor = autorRepository.findById(id);
		if (optionalAutor.isPresent()) {
			return autorConverter.entityToDto(optionalAutor.get());
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		autorRepository.deleteById(id);

	}

}
