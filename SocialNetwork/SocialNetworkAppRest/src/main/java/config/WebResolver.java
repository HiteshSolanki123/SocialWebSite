/*package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit")
public class WebResolver {
  @Bean
  public InternalResourceViewResolver getViewResolver()
  {
	  System.out.println("Resolver Called");
	  InternalResourceViewResolver InternalResourceViewResolver=new InternalResourceViewResolver();
	  InternalResourceViewResolver.setPrefix("/Web-INF/");
	  InternalResourceViewResolver.setSuffix(".jsp");
	  System.out.println("Resolver Created");
	  return InternalResourceViewResolver;
	  
  }
}
*/