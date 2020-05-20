package vojkan.bukumiric.biblioteka.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.ClanDto;
import vojkan.bukumiric.biblioteka.service.ClanService;

@Component
public class ClanDtoFormatter implements Formatter<ClanDto> {
	
	private ClanService clanService;
	@Autowired
	public ClanDtoFormatter(ClanService clanService) {
		this.clanService = clanService;
	}

	@Override
	public String print(ClanDto object, Locale locale) {
		
		return object.toString();
	}

	@Override
	public ClanDto parse(String text, Locale locale) throws ParseException {
		Long id = Long.parseLong(text);
		ClanDto clanDto = clanService.findById(id);
		return clanDto;
	}

}
