package com.catalyst.Core;

import java.util.Properties;
import com.catalyst.Config.Global;
import org.hibernate.SessionFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

/*
    Configuration File For Spring + Hibernate
*/
@EnableWebMvc                   // Tells Spring This Configuration Type Is WebMVC
@Configuration                  // Tells Spring This Is A Configuration Class
@EnableTransactionManagement    // Enables Spring's Transaction Management
@ComponentScan("com.catalyst")  // Tells Spring What Package Root To Scan For Componets
public class AppConfig extends WebMvcConfigurerAdapter
{
    // Overriding Default Spring Methods To Configure Spring The Way We Need
    
    // Telling Spring We Have Resources & Where They Are So We Dont Run Into Problems (Problems = MVC Mapping)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry hRegistry)
    {
        hRegistry.addResourceHandler("/Resources/**").addResourceLocations("/WEB-INF/Resources/*");
    }
    
    // Telling Spring To Use The Containers Default Servlet
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
    
    // SessionFactory Is Apart Of Hibernate, Its Responsible For The Creation Of Sessions (Also Hibernate)
    @Bean // @Bean Tells Spring That This Method Is Gonna Return An Object That Is To Be Registered As A Bean In The Spring Application Context
    public SessionFactory sessionFactory()
    {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.catalyst.User.Model");    // Where My Model Classes Are
        builder.addProperties(getHibernationProperties());  // Include Result Of The Method Below

        return builder.buildSessionFactory();
    }
    
    // Configuring Some Hibernate Properties
    private Properties getHibernationProperties()
    {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect", Global.DBDialect); // Or SQLServer2012Dialect

        return prop;
    }
    
    // Declaring Our DataSource (Database)
    @Bean(name = "dataSource")
    public BasicDataSource dataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(Global.DBDriver);
        ds.setUrl(Global.DBUrl);
        ds.setUsername(Global.DBUser);
        ds.setPassword(Global.DBPass);

        return ds;
    }

    // Binds A Hibernate Session From SessionFactory To A Thread
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s)
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
    
    // Telling Spring How To Resolve Url Path's (Where Our JSP's Are Located)
    @Bean
    public UrlBasedViewResolver setupViewResolver()
    {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/JSP/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }
    
    // BCrypt Is A Password Encoder. Used For Hashing New Passwords And Comparing Input To Password
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}