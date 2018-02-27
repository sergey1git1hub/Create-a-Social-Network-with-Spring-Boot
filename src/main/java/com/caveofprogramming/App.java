package com.caveofprogramming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@SpringBootApplication
public class App extends org.springframework.boot.context.web.SpringBootServletInitializer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	@Bean
    public UrlBasedViewResolver tilesViewResolver() {  
      UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();  
   
      tilesViewResolver.setViewClass(TilesView.class);  
      return tilesViewResolver;  
    }
	
	 @Bean
	    public TilesConfigurer tilesConfigurer(){
	        TilesConfigurer tilesConfigurer = new TilesConfigurer();
	        String[] defs = {"/WEB-INF/tiles.xml"};
	        tilesConfigurer.setDefinitions(defs);
	        //tilesConfigurer.setCheckRefresh(true);
	        return tilesConfigurer;
	    }
	 
	
}
