package vojkan.bukumiric.biblioteka.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vojkan.bukumiric.biblioteka.dto.AutorDto;

public class AutorDtoValidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {

		return AutorDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AutorDto autorDto = (AutorDto) target;

		if (autorDto.getIme() != null) {
			if (autorDto.getIme().length() < 3) {
				errors.rejectValue("ime", "AutorDto.ime", "Ime mora da sadrzi minimum tri slova");
			}
		}
		if (autorDto.getPrezime() != null) {
			if (autorDto.getIme().length() < 3) {
				errors.rejectValue("prezime", "AutorDto.prezime", "Prezime mora da sadrzi minimum tri slova");
			}
		}

	}
}
