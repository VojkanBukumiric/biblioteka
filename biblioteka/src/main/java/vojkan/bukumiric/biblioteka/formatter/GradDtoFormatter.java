package vojkan.bukumiric.biblioteka.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.GradDto;
import vojkan.bukumiric.biblioteka.service.GradService;

@Component
public class GradDtoFormatter implements Formatter<GradDto> {

	private final GradService gradService;

	@Autowired
	public GradDtoFormatter(GradService gradService) {
		this.gradService = gradService;
	}

	@Override
	public String print(GradDto object, Locale locale) {

		return object.toString();
	}

	@Override
	public GradDto parse(String text, Locale locale) throws ParseException {
		Long id = Long.parseLong(text);
		GradDto gradDto = gradService.findById(id);
		return gradDto;
	}

}
