package vojkan.bukumiric.biblioteka.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class PocetakPretplateFormatter implements Formatter<Date> {
	
	private SimpleDateFormat simpleDateFormat;
	
	@Autowired
	public PocetakPretplateFormatter(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	@Override
	public String print(Date object, Locale locale) {
		
		return object.toString();
	}

	

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		
		return simpleDateFormat.parse(text);
	}

}
