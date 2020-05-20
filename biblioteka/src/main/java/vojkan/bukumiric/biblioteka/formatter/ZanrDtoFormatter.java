package vojkan.bukumiric.biblioteka.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.ZanrDto;
import vojkan.bukumiric.biblioteka.service.ZanrService;

@Component
public class ZanrDtoFormatter implements Formatter<ZanrDto> {

	private final ZanrService zanrService;

	@Autowired
	public ZanrDtoFormatter(ZanrService zanrService) {
		this.zanrService = zanrService;
	}

	@Override
	public String print(ZanrDto object, Locale locale) {

		return object.toString();
	}

	@Override
	public ZanrDto parse(String text, Locale locale) throws ParseException {

		Long id = Long.parseLong(text);
		ZanrDto zanrDto = zanrService.findById(id);
		return zanrDto;
	}

}
