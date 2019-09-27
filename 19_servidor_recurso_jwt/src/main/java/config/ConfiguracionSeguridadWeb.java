package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridadWeb extends WebSecurityConfigurerAdapter {
	@Bean
	public AuthenticationManager authMg() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
  @Override  
   public void configure(HttpSecurity http) throws Exception {
  
		/*http.httpBasic().disable().anonymous().and().authorizeRequests()
        		.anyRequest().hasRole("ADMIN");
        		.and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
                //.anyRequest().access("hasRole('ADMIN')");
		http.csrf().disable().authorizeRequests()
        .anyRequest().permitAll();
		http.authorizeRequests()
		.anyRequest().hasRole("USERS");*/
	  http
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/prueba").permitAll()
      .anyRequest().authenticated();
    }
	
}
