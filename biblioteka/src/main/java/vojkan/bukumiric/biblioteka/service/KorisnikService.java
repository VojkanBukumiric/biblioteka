package vojkan.bukumiric.biblioteka.service;

import java.util.List;

import vojkan.bukumiric.biblioteka.dto.KorisnikDto;
import vojkan.bukumiric.biblioteka.exception.KorisnikValidationException;

public interface KorisnikService {
	
	public List<KorisnikDto> findByUserByNameAndPassword(KorisnikDto korisnikDto) throws KorisnikValidationException;

}
