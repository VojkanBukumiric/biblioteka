package vojkan.bukumiric.biblioteka.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.AutorDto;
import vojkan.bukumiric.biblioteka.service.AutorService;

@Component
public class AutorDtoFormatter implements Formatter<AutorDto>{
	
	private AutorService autorService;
	@Autowired
	public AutorDtoFormatter(AutorService autorService) {
		this.autorService = autorService;
	}

	@Override
	public String print(AutorDto object, Locale locale) {
		
		return object.toString();
	}

	@Override
	public AutorDto parse(String text, Locale locale) throws ParseException {
		Long id = Long.parseLong(text);
		AutorDto autorDto = autorService.findById(id);
		return autorDto;
	}

}
