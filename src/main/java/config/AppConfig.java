package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "services")
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(
                "static/index_old/lang/index",
                "static/messages/lang/messages",
                "static/login/lang/login",
                "static/404/lang/404");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
