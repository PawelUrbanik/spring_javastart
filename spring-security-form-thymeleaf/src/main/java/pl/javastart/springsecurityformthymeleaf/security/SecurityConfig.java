package pl.javastart.springsecurityformthymeleaf.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/").permitAll().
                anyRequest().authenticated().
                and()
                .formLogin()
                .loginPage("/loginform").permitAll()
                .loginProcessingUrl("/processingLogin")
                .usernameParameter("user")
                .passwordParameter("pass")
        .and()
                .logout()
                .logoutUrl("/logoutme")
                .logoutSuccessUrl("/")
                .permitAll()
        ;
    }
}
