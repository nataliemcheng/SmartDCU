package groupC.dcuSmartDashboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * 
 * Password encoder
 * must be implemented for logins to function
 * 
 */
@Configuration
public class utilsConfiguration {
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static String encodePassword(String password) {
		return passwordEncoder().encode(password);
	}
	
}
