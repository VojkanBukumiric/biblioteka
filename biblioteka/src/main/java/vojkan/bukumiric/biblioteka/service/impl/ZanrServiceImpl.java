package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.ZanrConverter;
import vojkan.bukumiric.biblioteka.dto.ZanrDto;
import vojkan.bukumiric.biblioteka.entity.Zanr;
import vojkan.bukumiric.biblioteka.repository.ZanrRepository;
import vojkan.bukumiric.biblioteka.service.ZanrService;

@Service
@Transactional
public class ZanrServiceImpl implements ZanrService {

	private ZanrRepository zanrRepository;
	private ZanrConverter zanrConverter;

	@Autowired
	public ZanrServiceImpl(ZanrRepository zanrRepository, ZanrConverter zanrConverter) {
		this.zanrRepository = zanrRepository;
		this.zanrConverter = zanrConverter;
	}

	@Override
	public void save(ZanrDto zanrDto) {
		zanrRepository.save(zanrConverter.dtoToEntity(zanrDto));

	}

	@Override
	public List<ZanrDto> findAll() {
		List<Zanr> zanrovi = zanrRepository.findAll();
		List<ZanrDto> zanroviDto = zanrConverter.convertEntityListToDtoList(zanrovi);
		return zanroviDto;
	}

	@Override
	public ZanrDto findById(Long id) {
		Optional<Zanr> optionalZanr = zanrRepository.findById(id);
		if (optionalZanr.isPresent()) {
			return zanrConverter.entityToDto(optionalZanr.get());
		} else {
			return null;
		}
	}

}
