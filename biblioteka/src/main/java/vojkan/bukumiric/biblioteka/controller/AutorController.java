package vojkan.bukumiric.biblioteka.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vojkan.bukumiric.biblioteka.dto.AutorDto;
import vojkan.bukumiric.biblioteka.enums.KnjizevnaVrsta;
import vojkan.bukumiric.biblioteka.service.AutorService;
import vojkan.bukumiric.biblioteka.validator.AutorDtoValidator;

@Controller
@RequestMapping(value = "autor")
public class AutorController {

	private final AutorService autorService;

	@Autowired
	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}

	@GetMapping(value = "home")
	public ModelAndView home() {
		System.out.println("====================================================================");
		System.out.println("====================AutorController: home()  ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("autor/home");
		return modelAndView;
	}

	@GetMapping(value = "add")
	public ModelAndView add() {
		System.out.println("====================================================================");
		System.out.println("==================== AutorController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("autor/add");
		AutorDto autorDto = new AutorDto();
		modelAndView.addObject("autorDto", autorDto);
		return modelAndView;
	}

	@PostMapping(value = "save")
	public ModelAndView save(@Valid @ModelAttribute(name = "autorDto") AutorDto autorDto, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("================================ NOT OK =================================");
			modelAndView.setViewName("autor/add");
			modelAndView.addObject("autorDto", autorDto);
		} else {
			System.out.println("================================     OK =================================");
			modelAndView.setViewName("autor/all");
			autorService.save(autorDto);
		}
		return modelAndView;
	}

	@GetMapping(value = "/details")
	public ModelAndView details(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("autor/details");
		modelAndView.addObject("autorDto", autorService.findById(id));
		return modelAndView;
	}

	@GetMapping(value = "/edit")
	public ModelAndView edit(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("autor/edit");
		modelAndView.addObject("autorDto", autorService.findById(id));
		return modelAndView;
	}

	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute("autorDto") AutorDto autorDto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("autor/edit");
			modelAndView.addObject("autorDto", autorDto);
		} else {
			autorService.save(autorDto);
			modelAndView.setViewName("autor/all");
		}
		return modelAndView;
	}

	@GetMapping(value = "/remove")
	public ModelAndView remove(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("autor/all");
		autorService.deleteById(id);
		return modelAndView;
	}

	@GetMapping(value = "all")
	public ModelAndView all() {
		ModelAndView modelAndView = new ModelAndView("autor/all");
		return modelAndView;
	}

	@ModelAttribute(value = "autorDto")
	public AutorDto autorDto() {
		return new AutorDto();
	}

	@ModelAttribute(value = "autors")
	public List<AutorDto> autorsDto() {
		return autorService.findAll();
	}

	@ModelAttribute(value = "knjizevnaVrsta")
	public List<KnjizevnaVrsta> knjizevneVrste() {
		return Arrays.asList(KnjizevnaVrsta.values());
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new AutorDtoValidator());
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

}
