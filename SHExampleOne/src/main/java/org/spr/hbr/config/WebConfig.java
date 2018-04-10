package org.spr.hbr.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.spr.hbr.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(Constants.WEB_PACKAGE_NAME)
public class WebConfig extends WebMvcConfigurerAdapter{

	 @Bean
	 public ViewResolver viewResolver(){
	  
	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	  resolver.setPrefix(Constants.VIEW_PREFIX_PATH);
	  resolver.setSuffix(Constants.VIEW_SUFFIX_PATH);
	  resolver.setExposeContextBeansAsAttributes(true);
	  return resolver;
	 }
	 
	 @Override
	 public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		 configurer.enable();
	 }

	 @Bean public Mapper dozerMapper() { 
		 return new DozerBeanMapper(); 
	 }
}