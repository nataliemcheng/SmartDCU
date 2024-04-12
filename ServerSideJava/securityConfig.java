package groupC.dcuSmartDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private CustomUserDetailsService userDetailsService;
	
	//Encodes passwords entered by users
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> {
				//Public Access to All Assets
				auth.requestMatchers("/assets/css/**", "/assets/js**", "/assets/images/**", "/assets/bundles/**", "/assets/fonts/ico/fonts/**", "/assets/plugin/**", "/oauth2/**").permitAll();
				//Public Access to Account Creation
				auth.requestMatchers("/auth-signup", "auth-password-reset").permitAll();
				//All Pages Containing Data Require Authentication
				auth.anyRequest().authenticated();
			})
			//Allows Oauth2 Login
			.oauth2Login(oauth -> {
				oauth.loginPage("/auth-signin");
			})
			//Custom Login Form
			.formLogin(form -> {
				form.loginPage("/auth-signin");
				form.permitAll();
				form.loginProcessingUrl("/signIN");
				form.usernameParameter("email");
				form.passwordParameter("password");
				form.defaultSuccessUrl("/index");
				form.failureUrl("/auth-signin?error=incorrect");
			})
			//User Logging Out Returns to Sign In Page
			.logout(logout -> {
				logout.logoutUrl("/signOUT");
				logout.logoutSuccessUrl("/auth-signin");
				logout.deleteCookies("JSESSIONID");
			});
		return http.build();
	}
}
