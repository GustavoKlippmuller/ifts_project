package lbk.group.configuration;

import org.springframework.beans.factory.annotation.Autowired; //OK
import org.springframework.beans.factory.annotation.Qualifier; //OK
import org.springframework.context.annotation.Configuration; //OK
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; //OK
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; //OK
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; //OK
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; //OK
import org.springframework.security.core.userdetails.UserDetailsService; //OK
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; //OK

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/imgs/**").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").loginProcessingUrl("/logincheck").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/loginsuccess").permitAll().and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();

	}

}
