package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.ClanKnjigaConverter;
import vojkan.bukumiric.biblioteka.dto.ClanKnjigaDto;
import vojkan.bukumiric.biblioteka.entity.ClanKnjiga;
import vojkan.bukumiric.biblioteka.repository.ClanKnjigaRepository;
import vojkan.bukumiric.biblioteka.service.ClanKnjigaService;

@Service
@Transactional
public class ClanKnjigaServiceImpl implements ClanKnjigaService {

	private ClanKnjigaRepository clanKnjigaRepository;
	private ClanKnjigaConverter clanKnjigaConverter;

	@Autowired
	public ClanKnjigaServiceImpl(ClanKnjigaRepository clanKnjigaRepository, ClanKnjigaConverter clanKnjigaConverter) {
		this.clanKnjigaRepository = clanKnjigaRepository;
		this.clanKnjigaConverter = clanKnjigaConverter;

	}

	@Override
	public void save(ClanKnjigaDto clanKnjigaDto) {
		clanKnjigaRepository.save(clanKnjigaConverter.dtoToEntity(clanKnjigaDto));

	}

	@Override
	public List<ClanKnjigaDto> findAll() {
		List<ClanKnjiga> clanKnjiga = clanKnjigaRepository.findAll();
		List<ClanKnjigaDto> clanKnjigaDto = clanKnjigaConverter.convertEntityListToDtoList(clanKnjiga);
		return clanKnjigaDto;
	}

	

}
