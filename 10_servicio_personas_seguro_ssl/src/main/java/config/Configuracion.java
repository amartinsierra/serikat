package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class Configuracion extends WebSecurityConfigurerAdapter{
	@Bean
	public AuthenticationManager authMg() throws Exception {
		return super.authenticationManagerBean();
	}
	//definición roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("cliente")
          .password("{noop}cliente") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("USER")
          .and()
        .withUser("admin")
          .password("{noop}admin")
          .roles("USER", "ADMIN");
		
		/*lo siguiente sería para el caso de que
		 * quisiéramos encriptar la password:
		 * auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password(new BCryptPasswordEncoder().encode("user1"))
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password(new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		
		/*la seguiente configuración sería para el caso de 
		 * usuarios en una base de datos
		 * auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled"
            	+ " from users where username=?")
        	.authoritiesByUsernameQuery("select username, authority "
            	+ "from authorities where username=?");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		//.antMatchers(HttpMethod.POST,"/lista").hasRole("ADMIN")
		.antMatchers("/lista").authenticated()	
		.and()
		.x509();
	
	}
}
