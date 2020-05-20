package vojkan.bukumiric.biblioteka.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.KnjigaDto;
import vojkan.bukumiric.biblioteka.service.KnjigaService;

@Component
public class KnjigaDtoFormatter implements Formatter<KnjigaDto>{
	
	private KnjigaService knjigaService;
	@Autowired
	public KnjigaDtoFormatter(KnjigaService knjigaService) {
		this.knjigaService = knjigaService;
	}

	@Override
	public String print(KnjigaDto object, Locale locale) {
		
		return object.toString();
	}

	@Override
	public KnjigaDto parse(String text, Locale locale) throws ParseException {
		
		Long id = Long.parseLong(text);
		KnjigaDto knjigaDto = knjigaService.findById(id);
		return knjigaDto;
	}

}
