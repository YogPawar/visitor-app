package com.yogsoft.visitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.yogsoft.visitor.converter.MemberEntityToMember;
import com.yogsoft.visitor.converter.MemberToMemberEntity;
import com.yogsoft.visitor.converter.UserEntitytoUser;
import com.yogsoft.visitor.converter.UserToUserEntity;
import com.yogsoft.visitor.converter.VisitorEntityToVisitor;
import com.yogsoft.visitor.converter.VisitorToVisitorEntity;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.yogsoft.visitor" })
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private UserEntitytoUser userEntitytoUser;

	@Autowired
	private UserToUserEntity userToUserEntity;

	@Autowired
	private MemberToMemberEntity memberEntity;

	@Autowired
	private MemberEntityToMember entityToMember;

	@Autowired
	private VisitorToVisitorEntity visitorToVisitorEntity;

	@Autowired
	private VisitorEntityToVisitor entityToVisitor;

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(userEntitytoUser);
		registry.addConverter(userToUserEntity);
		registry.addConverter(memberEntity);
		registry.addConverter(entityToMember);
		registry.addConverter(visitorToVisitorEntity);
		registry.addConverter(entityToVisitor);
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(1000000);
	    return multipartResolver;
	}

}
