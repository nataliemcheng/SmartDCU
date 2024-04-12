package groupC.dcuSmartDashboard;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/* 
 * Created this to add users to 
 * SQL for login testing
 * Cant add them directly in SQL as passwords need to be encoded
 */

@Component
public class createUserForTesting {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void createUser() throws SQLException {
		SQL_queryHandler.createUser("ADMIN@email.com", "name", passwordEncoder.encode("password"));
	}
	
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
	    this.passwordEncoder = passwordEncoder;
	}
	
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(utilsConfiguration.class);
	    PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
	    
	    createUserForTesting user = new createUserForTesting();
	    user.setPasswordEncoder(passwordEncoder);
	    
	    user.createUser();
	}
	
}
