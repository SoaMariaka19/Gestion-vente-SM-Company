package school.hei.gestionVente.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import school.hei.gestionVente.model.User;
import school.hei.gestionVente.service.SecurityService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final SecurityService securityService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET , "*/**").permitAll()
            .antMatchers(HttpMethod.POST , "supplies/**").hasAnyRole(User.Role.SELLER.toString())
            .antMatchers(HttpMethod.DELETE , "*/**").hasRole(User.Role.SELLER.toString())
            .antMatchers(HttpMethod.PUT , "*/**").hasRole(User.Role.SELLER.toString())
            .and()
            .formLogin()
            .and()
            .logout()
            .permitAll()
            .and()
            .csrf()
            .disable()
            .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(securityService);
    return provider;
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
    return securityService;
  }
}
