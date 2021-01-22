package com.alex.prueba;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alex.prueba.dao.HeroDao;
import com.alex.prueba.modelo.Hero;
import com.googlecode.jmapper.api.JMapperAPI;

@SpringBootApplication
public class HeroesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HeroesApplication.class, args);
	}

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(HeroesApplication.class);
	  }
	
	
	  @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200")
	                .allowedMethods("*")
	                .allowedHeaders("*");
	            }
	        };
	    }
	
	  @Bean
	  CommandLineRunner initData(HeroDao heroDao) {
	      return (args) -> {
	
	    	  heroDao.saveAll(Arrays.asList(new Hero("Antman"),
	    			  						new Hero("Iron man"),
	    			  						new Hero("Thor"),
	    			  						new Hero("Felipez360"),
	    			  						new Hero("Jack Sparrow"),
	    			  						new Hero("Urgot"),
	    			  						new Hero("Steve"),
	    			  						new Hero("Teemo")
	                                        ));
	
	
	      };
	  }
	
	  @Bean
	  public JMapperAPI modelJMapperApi() {
	  	return new JMapperAPI();
	  }
}
