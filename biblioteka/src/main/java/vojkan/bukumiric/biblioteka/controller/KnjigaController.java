package vojkan.bukumiric.biblioteka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vojkan.bukumiric.biblioteka.dto.AutorDto;
import vojkan.bukumiric.biblioteka.dto.KnjigaDto;
import vojkan.bukumiric.biblioteka.dto.ZanrDto;
import vojkan.bukumiric.biblioteka.service.AutorService;
import vojkan.bukumiric.biblioteka.service.KnjigaService;
import vojkan.bukumiric.biblioteka.service.ZanrService;

@Controller
@RequestMapping(value = "knjiga")
public class KnjigaController {

	private final KnjigaService knjigaService;
	private final ZanrService zanrService;
	private final AutorService autorService;

	@Autowired
	public KnjigaController(KnjigaService knjigaService, ZanrService zanrService, AutorService autorService) {
		this.knjigaService = knjigaService;
		this.zanrService = zanrService;
		this.autorService = autorService;
	}

	@GetMapping(value = "home")
	public ModelAndView home() {
		System.out.println("====================================================================");
		System.out.println("====================KnjigaController: home()  ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("knjiga/home");
		return modelAndView;
	}

	@GetMapping(value = "add")
	public ModelAndView add() {
		System.out.println("====================================================================");
		System.out.println("==================== KnjigaController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("knjiga/add");
		KnjigaDto knjigaDto = new KnjigaDto();
		modelAndView.addObject("knjigaDto", knjigaDto);
		return modelAndView;
	}

	@PostMapping(value = "save")
	public ModelAndView save(@Valid @ModelAttribute(name = "knjigaDto") KnjigaDto knjigaDto, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("================================ NOT OK =================================");
			modelAndView.setViewName("knjiga/add");
			modelAndView.addObject("knjigaDto", knjigaDto);
		} else {
			System.out.println("================================     OK =================================");
			modelAndView.setViewName("knjiga/all");
			knjigaService.save(knjigaDto);
		}
		return modelAndView;
	}

	@GetMapping(value = "details")
	public ModelAndView details(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("knjiga/details");
		modelAndView.addObject("knjigaDto", knjigaService.findById(id));
		return modelAndView;
	}

	@GetMapping(value = "edit")
	public ModelAndView edit(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("knjiga/edit");
		modelAndView.addObject("knjigaDto", knjigaService.findById(id));
		return modelAndView;
	}

	@PostMapping(value = "update")
	public ModelAndView update(@Valid @ModelAttribute("knjigaDto") KnjigaDto knjigaDto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("knjiga/edit");
			modelAndView.addObject("knjigaDto", knjigaDto);
		} else {
			knjigaService.save(knjigaDto);
			modelAndView.setViewName("knjiga/all");
		}
		return modelAndView;
	}

	@GetMapping(value = "remove")
	public ModelAndView remove(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("knjiga/all");
		knjigaService.deleteById(id);
		return modelAndView;
	}

	@GetMapping(value = "all")
	public ModelAndView all() {
		ModelAndView modelAndView = new ModelAndView("knjiga/all");
		return modelAndView;
	}

	@ModelAttribute(value = "knjige")
	public List<KnjigaDto> cities() {
		return knjigaService.findAll();
	}

	@ModelAttribute(value = "zanrovi")
	public List<ZanrDto> zanrDto() {
		return zanrService.findAll();
	}

	@ModelAttribute(value = "autors")
	public List<AutorDto> autorsDto() {
		return autorService.findAll();
	}

}
