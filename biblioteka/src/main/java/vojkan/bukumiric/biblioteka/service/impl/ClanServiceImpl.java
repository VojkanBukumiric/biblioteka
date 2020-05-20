package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.ClanConverter;
import vojkan.bukumiric.biblioteka.dto.ClanDto;
import vojkan.bukumiric.biblioteka.entity.Clan;
import vojkan.bukumiric.biblioteka.repository.ClanRepository;
import vojkan.bukumiric.biblioteka.service.ClanService;

@Service
@Transactional
public class ClanServiceImpl implements ClanService {

	private ClanRepository clanRepository;
	private ClanConverter clanConverter;

	@Autowired
	public ClanServiceImpl(ClanRepository clanRepository, ClanConverter clanConverter) {
		this.clanRepository = clanRepository;
		this.clanConverter = clanConverter;
	}

	@Override
	public void save(ClanDto clanDto) {
		clanRepository.save(clanConverter.dtoToEntity(clanDto));

	}

	@Override
	public List<ClanDto> findAll() {
		List<Clan> clanovi = clanRepository.findAll();
		List<ClanDto> clanoviDto = clanConverter.convertEntityListToDtoList(clanovi);
		return clanoviDto;
	}

	@Override
	public ClanDto findById(Long id) {
		Optional<Clan> optionalClan = clanRepository.findById(id);
		if (optionalClan.isPresent()) {
			return clanConverter.entityToDto(optionalClan.get());
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		clanRepository.deleteById(id);

	}

	@Override
	public List<ClanDto> findByBrClanskeKarte(ClanDto clanDto) {
		
		return clanConverter.convertEntityListToDtoList(clanRepository.findByBrClanskeKarte(clanDto.getBrClanskeKarte()));
	}

}
