package co.devops.thymeleaf3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ResourcesHandlerConfig implements WebMvcConfigurer {
    @Value("${file.clint.path}")
    private String fileClintPath;
    @Value("${file.server.path}")
    private String fileServerPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler(fileClintPath).addResourceLocations("file:"+fileServerPath);
    }
}
