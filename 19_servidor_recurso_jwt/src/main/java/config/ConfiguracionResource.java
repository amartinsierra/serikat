package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ConfiguracionResource extends ResourceServerConfigurerAdapter {

	@Value("${application.jwtSigningKey}")
	private String signingKey;

	
	@Override
	public void configure(ResourceServerSecurityConfigurer config) {
	    config.resourceId("default-resources"); // this matches the resourceId in OAuth2JwtConfig
	    config.tokenServices(this.getTokenService());
	}

	@Bean
	public TokenStore jwtTokenStore() {
	    return new JwtTokenStore(this.jwtTokenConverter());
	}

	@Bean
	// Get this resource server to verify its own JWT token, instead of passing the request to the jwt-server via security.oauth2.resource.userInfoUri
	public JwtAccessTokenConverter jwtTokenConverter() {
	    final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    converter.setSigningKey(signingKey);
	    return converter;
	}

	@Bean
	@Primary
	public DefaultTokenServices getTokenService() {
	    final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	    defaultTokenServices.setTokenStore(this.jwtTokenStore());
	    return defaultTokenServices;
	}
	@Override  
	   public void configure(HttpSecurity http) throws Exception {
	  
		  http
	      .authorizeRequests()
	      .antMatchers("/prueba").permitAll()
	      .anyRequest().authenticated();
	    }
	
}
