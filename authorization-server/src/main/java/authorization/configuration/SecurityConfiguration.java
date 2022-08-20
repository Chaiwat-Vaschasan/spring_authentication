package authorization.configuration;

import authorization.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    @Autowired private AccountService accountService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(accountService)
                .cors().disable().csrf().disable()
                .authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/oauth2/**").authenticated())
                .formLogin().loginPage("/login").failureUrl("/login-error").permitAll().and()
                .authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/api/**").authenticated()).oauth2ResourceServer().jwt();

        return http.build();
    }



}