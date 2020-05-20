package vojkan.bukumiric.biblioteka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import vojkan.bukumiric.biblioteka.dto.ClanDto;
import vojkan.bukumiric.biblioteka.dto.GradDto;
import vojkan.bukumiric.biblioteka.service.ClanService;
import vojkan.bukumiric.biblioteka.service.GradService;
import vojkan.bukumiric.biblioteka.validator.ClanDtoValidator;

@Controller
@RequestMapping(value = "clan")
public class ClanController {

	private final ClanService clanService;
	private final GradService gradService;

	@Autowired
	public ClanController(ClanService clanService, GradService gradService) {
		this.clanService = clanService;
		this.gradService = gradService;
	}

	@GetMapping(value = "home")
	public ModelAndView home() {
		System.out.println("====================================================================");
		System.out.println("====================ClanController: home()  ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("clan/home");
		return modelAndView;
	}

	@GetMapping(value = "add")
	public ModelAndView add() {
		System.out.println("====================================================================");
		System.out.println("==================== ClanController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("clan/add");
		ClanDto clanDto = new ClanDto();
		modelAndView.addObject("clanDto", clanDto);
		return modelAndView;
	}

	@PostMapping(value = "save")
	public ModelAndView save(@Valid @ModelAttribute(name = "clanDto") ClanDto clanDto, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("================================ NOT OK =================================");
			modelAndView.setViewName("clan/add");
			modelAndView.addObject("clanDto", clanDto);
		} else {
			System.out.println("================================     OK =================================");
			modelAndView.setViewName("clan/all");
			clanService.save(clanDto);
		}
		return modelAndView;
	}

	@GetMapping(value = "/details")
	public ModelAndView details(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("clan/details");
		modelAndView.addObject("clanDto", clanService.findById(id));
		return modelAndView;
	}

	@GetMapping(value = "/edit")
	public ModelAndView edit(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("clan/edit");
		modelAndView.addObject("clanDto", clanService.findById(id));
		return modelAndView;
	}

	@PostMapping(value = "/update")
	public ModelAndView update(@Valid @ModelAttribute("clanDto") ClanDto clanDto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("clan/edit");
			modelAndView.addObject("clanDto", clanDto);
		} else {
			clanService.save(clanDto);
			;
			modelAndView.setViewName("clan/all");
		}
		return modelAndView;
	}

	@GetMapping(value = "/remove")
	public ModelAndView remove(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("clan/all");
		clanService.deleteById(id);
		return modelAndView;
	}

	@GetMapping(value = "all")
	public ModelAndView all() {
		ModelAndView modelAndView = new ModelAndView("clan/all");
		return modelAndView;
	}

	@ModelAttribute(value = "clanDto")
	public ClanDto clanDto() {
		return new ClanDto();
	}

	@ModelAttribute(value = "clanovi")
	public List<ClanDto> clanoviDto() {
		return clanService.findAll();
	}

	@ModelAttribute(value = "gradovi")
	public List<GradDto> gradovi() {
		return gradService.findAll();
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ClanDtoValidator(clanService));
	}

}
