package vojkan.bukumiric.biblioteka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vojkan.bukumiric.biblioteka.converter.KorisnikConverter;
import vojkan.bukumiric.biblioteka.dto.KorisnikDto;
import vojkan.bukumiric.biblioteka.entity.Korisnik;
import vojkan.bukumiric.biblioteka.exception.KorisnikValidationException;
import vojkan.bukumiric.biblioteka.repository.KorisnikRepository;
import vojkan.bukumiric.biblioteka.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	private final KorisnikRepository korisnikRepository;
	private final KorisnikConverter korisnikConverter;

	@Autowired
	public KorisnikServiceImpl(KorisnikRepository korisnikRepository, KorisnikConverter korisnikConverter) {
		this.korisnikRepository = korisnikRepository;
		this.korisnikConverter = korisnikConverter;
	}

	@Override
	public List<KorisnikDto> findByUserByNameAndPassword(KorisnikDto korisnikDto) throws KorisnikValidationException {

		List<Korisnik> korisnici = korisnikRepository.findByImeAndLozinka(korisnikDto.getIme(),
				korisnikDto.getLozinka());
		List<KorisnikDto> korisniciDto = korisnikConverter.convertEntityListToDtoList(korisnici);
		if (korisniciDto.isEmpty()) {
			throw new KorisnikValidationException("Pogresno korisnicko ime i lozinka");
		}
		return korisniciDto;
	}

}
