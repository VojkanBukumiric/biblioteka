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
import org.springframework.web.servlet.ModelAndView;

import vojkan.bukumiric.biblioteka.dto.ClanDto;
import vojkan.bukumiric.biblioteka.dto.ClanKnjigaDto;
import vojkan.bukumiric.biblioteka.dto.KnjigaDto;
import vojkan.bukumiric.biblioteka.service.ClanKnjigaService;
import vojkan.bukumiric.biblioteka.service.ClanService;
import vojkan.bukumiric.biblioteka.service.KnjigaService;

@Controller
@RequestMapping(value = "iznajmiknjigu")
public class ClanKnjigaController {

	private final ClanKnjigaService clanKnjigaService;
	private final ClanService clanService;
	private final KnjigaService knjigaService;

	@Autowired
	public ClanKnjigaController(ClanKnjigaService clanKnjigaService, ClanService clanService,
			KnjigaService knjigaService) {
		this.clanKnjigaService = clanKnjigaService;
		this.clanService = clanService;
		this.knjigaService = knjigaService;
	}

	@GetMapping(value = "home")
	public ModelAndView home() {
		System.out.println("====================================================================");
		System.out.println("====================ClanKnjigaController: home()  ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("iznajmiknjigu/home");
		return modelAndView;
	}

	@GetMapping(value = "add")
	public ModelAndView add() {
		System.out.println("====================================================================");
		System.out.println("==================== ClanKnjigaController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("iznajmiknjigu/add");
		ClanKnjigaDto clanKnjigaDto = new ClanKnjigaDto();
		modelAndView.addObject("clanKnjigaDto", clanKnjigaDto);
		return modelAndView;
	}

	@PostMapping(value = "save")
	public ModelAndView save(@Valid @ModelAttribute(name = "clanKnjigaDto") ClanKnjigaDto clanKnjigaDto,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("================================ NOT OK =================================");
			modelAndView.setViewName("iznajmiknjigu/add");
			modelAndView.addObject("clanKnjigaDto", clanKnjigaDto);
		} else {
			System.out.println("================================     OK =================================");
			modelAndView.setViewName("iznajmiknjigu/all");
			clanKnjigaService.save(clanKnjigaDto);
		}
		return modelAndView;
	}

	@GetMapping(value = "all")
	public ModelAndView all() {
		ModelAndView modelAndView = new ModelAndView("iznajmiknjigu/all");
		return modelAndView;
	}

	@ModelAttribute(name = "clanKnjigaDto")
	public ClanKnjigaDto clanKnjigaDto() {
		return new ClanKnjigaDto();
	}

	@ModelAttribute(name = "iznajmljeneKnjige")
	public List<ClanKnjigaDto> iznajmljeneKnjige() {
		return clanKnjigaService.findAll();
	}

	@ModelAttribute(name = "clanovi")
	public List<ClanDto> clanovi() {
		return clanService.findAll();
	}

	@ModelAttribute(name = "knjige")
	public List<KnjigaDto> knjige() {
		return knjigaService.findAll();
	}
	

}
