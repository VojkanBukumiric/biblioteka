package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.GradConverter;
import vojkan.bukumiric.biblioteka.dto.GradDto;
import vojkan.bukumiric.biblioteka.entity.Grad;
import vojkan.bukumiric.biblioteka.repository.GradRepository;
import vojkan.bukumiric.biblioteka.service.GradService;

@Service
@Transactional
public class GradServiceImpl implements GradService {

	private GradRepository gradRepository;
	private GradConverter gradConverter;

	@Autowired
	public GradServiceImpl(GradRepository gradRepository, GradConverter gradConverter) {
		this.gradRepository = gradRepository;
		this.gradConverter = gradConverter;
	}

	@Override
	public void save(GradDto gradDto) {
		gradRepository.save(gradConverter.dtoToEntity(gradDto));

	}

	@Override
	public List<GradDto> findAll() {
		List<Grad> gradovi = gradRepository.findAll();
		List<GradDto> gradoviDto = gradConverter.convertEntityListToDtoList(gradovi);
		return gradoviDto;
	}

	@Override
	public GradDto findById(Long id) {
		Optional<Grad> optionalGrad = gradRepository.findById(id);
		if (optionalGrad.isPresent()) {
			return gradConverter.entityToDto(optionalGrad.get());
		} else {
			return null;
		}
	}

}
