package vojkan.bukumiric.biblioteka.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vojkan.bukumiric.biblioteka.dto.KorisnikDto;
import vojkan.bukumiric.biblioteka.exception.KorisnikValidationException;
import vojkan.bukumiric.biblioteka.service.KorisnikService;

@Controller
@RequestMapping(value = "authentication")
public class AuthenticationController {
	private final KorisnikService korisnikService;

	@Autowired
	public AuthenticationController(KorisnikService korisnikService) {
		this.korisnikService = korisnikService;
	}

	@GetMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("/authentication/login");
		modelAndView.addObject("korisnikDto", new KorisnikDto());
		return modelAndView;
	}

	@PostMapping(value = "/login")
	public ModelAndView confirm(@Valid @ModelAttribute("korisnikDto") KorisnikDto korisnikDto, BindingResult result,
			HttpServletRequest request) throws KorisnikValidationException {
		ModelAndView modelAndView = new ModelAndView();
		korisnikService.findByUserByNameAndPassword(korisnikDto);
		if (result.hasErrors()) {
			modelAndView.setViewName("/authentication/login");

			modelAndView.addObject("korisnikDto", korisnikDto);
		} else {

			HttpSession session = request.getSession(false);
			
			modelAndView.setViewName("index");
			session.setAttribute("korisnik", korisnikDto);
		
		}
		return modelAndView;
	}

	@ModelAttribute(name = "korisnikDto")
	public KorisnikDto korisnikDto() {
		return new KorisnikDto();
	}

	@ExceptionHandler(KorisnikValidationException.class)
	public ModelAndView exceptionHandler(KorisnikValidationException korisnikValidationException) {
		ModelAndView modelAndView = new ModelAndView("/authentication/login");
		modelAndView.addObject("errorMessage", korisnikValidationException.getMessage());
		modelAndView.addObject("korisnikDto", korisnikDto());
		return modelAndView;
	}

}
