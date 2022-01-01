package net.codejava.contact.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import net.codejava.contact.dao.AttendanceDAO;
import net.codejava.contact.dao.AttendanceDAOImpl;
import net.codejava.contact.dao.AttendanceRecordDAO;
import net.codejava.contact.dao.AttendanceRecordDAOImpl;
import net.codejava.contact.dao.ClassroomDAO;
import net.codejava.contact.dao.ClassroomDAOImpl;
import net.codejava.contact.dao.ContactDAO;
import net.codejava.contact.dao.ContactDAOImpl;
import net.codejava.contact.dao.ReportCardDAO;
import net.codejava.contact.dao.ReportCardDAOImpl;
import net.codejava.contact.dao.StudentHomeworkDAO;
import net.codejava.contact.dao.StudentHomeworkDAOImpl;
import net.codejava.contact.dao.StudentSubmissionDAO;
import net.codejava.contact.dao.StudentSubmissionDAOImpl;
import net.codejava.contact.dao.TimeTableDAO;
import net.codejava.contact.dao.TimeTableDAOImpl;
import net.codejava.contact.dao.UserDetailsDAO;
import net.codejava.contact.dao.UserDetailsDAOImpl;
import net.codejava.contact.dao.resultDAO;
import net.codejava.contact.dao.resultDAOImpl;
import net.codejava.contact.dao.spouseInfoDAO;
import net.codejava.contact.dao.spouseInfoDAOImpl;
import net.codejava.contact.dao.subjectSchoolDAO;
import net.codejava.contact.dao.subjectSchoolDAOImpl;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="net.codejava.contact")
public class SpringMvcConfig implements WebMvcConfigurer {

	 @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/db_sis");
	        dataSource.setUsername("root");
	        dataSource.setPassword("abc123");
	         
	        return dataSource;
	    
	    }
	 
	  @Bean(name="JSPViewResolver")
	    public ViewResolver getViewResolver(){
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	  
	  
	  @Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			// TODO Auto-generated method stub
		  registry.addResourceHandler("/URL/**").addResourceLocations("/resources/");
		}
	  
	  @Bean
	  public MultipartResolver multipartResolver(){
		  
		  CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		  resolver.setMaxUploadSize(5242880);
		  return resolver;
	  }
	  
	  @Bean
	    public ContactDAO getContactDAO() {
	        return new ContactDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public AttendanceDAO getAttendanceDAO() {
	        return new AttendanceDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public AttendanceRecordDAO getAttendanceRecordDAO() {
	        return new AttendanceRecordDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public ClassroomDAO getClassroomDAO() {
	        return new ClassroomDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public subjectSchoolDAO getsubjectSchoolDAO() {
	        return new subjectSchoolDAOImpl(getDataSource());
	    }
	  @Bean
	    public resultDAO getresultDAO() {
	        return new resultDAOImpl(getDataSource());
	    }
	  @Bean
	    public ReportCardDAO getreportCardDAO() {
	        return new ReportCardDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public spouseInfoDAO getspouseInfoDAO() {
	        return new spouseInfoDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public StudentHomeworkDAO getStudentHomeworkDAO() {
	        return new StudentHomeworkDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public StudentSubmissionDAO getStudentSubmissionDAO() {
	        return new StudentSubmissionDAOImpl(getDataSource());
	    }
	  @Bean
	    public TimeTableDAO getTimeTableDAO() {
	        return new TimeTableDAOImpl(getDataSource());
	    }
	  
	  @Bean
	    public UserDetailsDAO getUserDetailsDAO() {
	        return new UserDetailsDAOImpl(getDataSource());
	    }

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		
	}
	  
	  
}

