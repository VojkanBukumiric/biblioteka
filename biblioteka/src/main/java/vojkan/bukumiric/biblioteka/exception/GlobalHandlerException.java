package vojkan.bukumiric.biblioteka.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(LoginFailException.class)
	public String exceptionHandler(LoginFailException loginFailException, RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("errorMessage", loginFailException.getMessage());

		return "redirect:/authentication/login";
	}

}
