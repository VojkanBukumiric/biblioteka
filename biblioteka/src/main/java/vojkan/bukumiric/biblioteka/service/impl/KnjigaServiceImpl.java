package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.KnjigaConverter;
import vojkan.bukumiric.biblioteka.dto.KnjigaDto;
import vojkan.bukumiric.biblioteka.entity.Knjiga;
import vojkan.bukumiric.biblioteka.repository.KnjigaRepository;
import vojkan.bukumiric.biblioteka.service.KnjigaService;

@Service
@Transactional
public class KnjigaServiceImpl implements KnjigaService {
	
	private KnjigaRepository knjigaRepository;
	private KnjigaConverter knjigaConverter;
	@Autowired
	public KnjigaServiceImpl(KnjigaRepository knjigaRepository, KnjigaConverter knjigaConverter) {
		this.knjigaRepository = knjigaRepository;
		this.knjigaConverter = knjigaConverter;
	}

	@Override
	public void save(KnjigaDto knjigaDto) {
		knjigaRepository.save(knjigaConverter.dtoToEntity(knjigaDto));
		
	}

	@Override
	public List<KnjigaDto> findAll() {
		List<Knjiga> knjige = knjigaRepository.findAll();
		List<KnjigaDto> knjigeDto = knjigaConverter.convertEntityListToDtoList(knjige);
		return knjigeDto;
	}

	@Override
	public KnjigaDto findById(Long id) {
		Optional<Knjiga> optionalKnjiga = knjigaRepository.findById(id);
		if (optionalKnjiga.isPresent()) {
			return knjigaConverter.entityToDto(optionalKnjiga.get());
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		knjigaRepository.deleteById(id);
		
	}

}
