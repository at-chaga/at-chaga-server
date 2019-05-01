package configuration;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import controller.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@Import({ RootApplicationContextConfig.class })
@ComponentScan(basePackageClasses = Controller.class)
public class AtChagaApiConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public HandlebarsViewResolver handlebarsViewResolver() {
		HandlebarsViewResolver handlebarsViewResolver = new HandlebarsViewResolver();
		handlebarsViewResolver.setPrefix("/views/");
		handlebarsViewResolver.setOrder(0);
		handlebarsViewResolver.setSuffix(".hbs");

		return handlebarsViewResolver;
	}
}
