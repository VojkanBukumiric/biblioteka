package vojkan.bukumiric.biblioteka.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vojkan.bukumiric.biblioteka.dto.GradDto;
import vojkan.bukumiric.biblioteka.entity.Grad;

@Component
public class GradConverter {

	public GradDto entityToDto(Grad grad) {
		return new GradDto(grad.getId(), grad.getNaziv());
	}

	public Grad dtoToEntity(GradDto gradDto) {
		return new Grad(gradDto.getId(), gradDto.getNaziv());
	}

	public List<Grad> convertDtoListToEntityList(List<GradDto> dtoList) {
		List<Grad> gradEntityList = new ArrayList<Grad>();
		for (GradDto gradDto : dtoList) {
			gradEntityList.add(dtoToEntity(gradDto));
		}
		return gradEntityList;
	}

	public List<GradDto> convertEntityListToDtoList(List<Grad> entityList) {
		List<GradDto> gradDtoList = new ArrayList<GradDto>();
		for (Grad grad : entityList) {
			gradDtoList.add(entityToDto(grad));
		}
		return gradDtoList;
	}

}
