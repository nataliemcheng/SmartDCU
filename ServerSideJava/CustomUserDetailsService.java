package groupC.dcuSmartDashboard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Custom User Details Service to Allow Login to be Checked Against SQL
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try { List<User> userList = SQL_queryHandler.userLogin();
		for(int i = 0; i < userList.size(); i++) { //ITERATE THROUGH LIST
			if(userList.get(i).getUsername().equals(username)) { 
				return User.withUsername(userList.get(i).getUsername())
						.password(userList.get(i).getPassword())
						.authorities(userList.get(i).getAuthorities())
						.build();
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null; //Alerting to Incorrect Username/Password Handled in auth-signin.html
	}
}	
