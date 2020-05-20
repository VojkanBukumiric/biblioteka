package vojkan.bukumiric.biblioteka.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vojkan.bukumiric.biblioteka.dto.ClanDto;
import vojkan.bukumiric.biblioteka.service.ClanService;

public class ClanDtoValidator implements Validator{
	
	private ClanService clanService;
	@Autowired
	public ClanDtoValidator(ClanService clanService) {
		this.clanService = clanService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ClanDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClanDto clanDto = (ClanDto) target;
		List<ClanDto> duplikatBrClanskeKarte =clanService.findByBrClanskeKarte(clanDto);
		if(!duplikatBrClanskeKarte.isEmpty() && duplikatBrClanskeKarte.get(0).getId() != clanDto.getId()) {
			errors.rejectValue("brClanskeKarte", "ClanDro.brClanskeKarte", "broj clanske karte vec postoji");
		}
		
		if(clanDto.getEmail()!=null) {
			if(!clanDto.getEmail().contains("@")) {
				errors.rejectValue("email", "ClanDto.email", 
						"Mail mora da sadrzi karakter @");
			}
		}
		if(clanDto.getIme()!= null) {
			if(clanDto.getIme().length() < 3) {
				errors.rejectValue("ime", "ClanDto.ime", 
						"Minimalan broj karaktera za ime je tri");
			}
		}
		if(clanDto.getPrezime()!= null) {
			if(clanDto.getPrezime().length() < 3) {
				errors.rejectValue("prezime", "ClanDto.prezime", 
						"Minimalan broj karaktera za prezime je tri");
			}
		}
		if(clanDto.getAdresa()!= null) {
			if(clanDto.getAdresa().length() > 30) {
				errors.rejectValue("adresa", "ClanDto.adresa", 
						"Maksimalan broj karaktera za adresu je 30");
			}
		}
		
	}

}
