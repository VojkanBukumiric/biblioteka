package vojkan.bukumiric.biblioteka.config;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import vojkan.bukumiric.biblioteka.formatter.AutorDtoFormatter;
import vojkan.bukumiric.biblioteka.formatter.ClanDtoFormatter;
import vojkan.bukumiric.biblioteka.formatter.GradDtoFormatter;
import vojkan.bukumiric.biblioteka.formatter.KnjigaDtoFormatter;
import vojkan.bukumiric.biblioteka.formatter.KrajPretplateFormatter;
import vojkan.bukumiric.biblioteka.formatter.PocetakPretplateFormatter;
import vojkan.bukumiric.biblioteka.formatter.ZanrDtoFormatter;
import vojkan.bukumiric.biblioteka.interceptor.LoginInterceptor;
import vojkan.bukumiric.biblioteka.service.AutorService;
import vojkan.bukumiric.biblioteka.service.ClanService;
import vojkan.bukumiric.biblioteka.service.GradService;
import vojkan.bukumiric.biblioteka.service.KnjigaService;
import vojkan.bukumiric.biblioteka.service.ZanrService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "vojkan.bukumiric.biblioteka.controller", "vojkan.bukumiric.biblioteka.formatter",
		"vojkan.bukumiric.biblioteka.exception", "vojkan.bukumiric.biblioteka.interceptor" })
public class MyWebContextConfig implements WebMvcConfigurer {

	private GradService gradService;
	private ZanrService zanrService;
	private AutorService autorService;
	private ClanService clanService;
	private KnjigaService knjigaService;

	@Autowired
	public MyWebContextConfig(GradService gradService, ZanrService zanrService, AutorService autorService,
			ClanService clanService, KnjigaService knjigaService) {
		this.gradService = gradService;
		this.zanrService = zanrService;
		this.autorService = autorService;
		this.clanService = clanService;
		this.knjigaService = knjigaService;
		System.out.println("=================================================================");
		System.out.println("==================== MyWebContextConfig =========================");
		System.out.println("=================================================================");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/authentication/login");

	}

	@Bean(name = "simpleDateFormat")
	public SimpleDateFormat simpleDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new GradDtoFormatter(gradService));
		registry.addFormatter(new ZanrDtoFormatter(zanrService));
		registry.addFormatter(new PocetakPretplateFormatter(simpleDateFormat()));
		registry.addFormatter(new KrajPretplateFormatter(simpleDateFormat()));
		registry.addFormatter(new AutorDtoFormatter(autorService));
		registry.addFormatter(new ClanDtoFormatter(clanService));
		registry.addFormatter(new KnjigaDtoFormatter(knjigaService));
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor());
	}

}
