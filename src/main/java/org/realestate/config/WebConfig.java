/**
 * Setting up the configuration.
 */

package org.realestate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Configuration tells Spring that a given class is configuration class and contains bean definitions and dependencies.
 * Beans are objects that are managed by Spring. The @Bean annotation is used to define a bean.
 * @EnableWebMvc allows you to import your Spring MVC configuration from the WebMvcConfigurationSupport class.
 * You can also implement, for example, the WebMvcConfigurer interface, which has a whole bunch of methods,
 * and customize everything to your liking, but we don't need to delve into this yet, the standard settings will be enough.
 * @ComponentScan tells Spring where to look for the components it should manage, i.e. classes marked with
 * the @Component annotation or its derivatives, such as @Controller, @Repository, @Service.
 * These annotations automatically identify the class bean.
 * The @EnableWebMvc annotation allows you not to configure anything, but just use the default configuration.
 * And the WebMvcConfigurer interface allows you to override configuration methods. So we can use the default
 * configuration, but at the same time customize some points for ourselves.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.realestate")
public class WebConfig implements WebMvcConfigurer {

    /**
     * In this case, we need the addResourceHandlers method, with which we will indicate the location
     * of static web resources.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("/res/");
    }

    /**
     * In the viewResolver () method, we create its implementation and determine exactly where to look for views in the
     * webapp. So when in the controller method we set the name "index" the view will be found as "/pages/index.jsp"
     * @return ViewResolver is the interface needed to find a view by name.
     */
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}