package groupC.dcuSmartDashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.zaxxer.hikari.HikariDataSource;

public class SQL_queryHandler {
	//Create connection pool for SQL
	public static DataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/smartdcu");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setMaximumPoolSize(5);
		return dataSource;
	}

	//Returns List of all Users in SQL. User type contains email, password, role
	public static List<User> userLogin() throws SQLException {
		DataSource dataSource = getDataSource();
		
		List<User> userDetails = new ArrayList<>();
		try(Connection conn = dataSource.getConnection()){
			PreparedStatement statement = conn.prepareStatement("select smartdcu.users.email, smartdcu.users.password, smartdcu.roles.roleName from smartdcu.users "
					+ "join smartdcu.user_roles on smartdcu.users.uuid = smartdcu.user_roles.uuid "
					+ "join smartdcu.roles on smartdcu.user_roles.roleID = smartdcu.roles.roleID;");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				String role = rs.getString("roleName");
				
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(role));
				User user = new User(email, password, authorities);
				userDetails.add(user);
			}
			return userDetails;
		}
	}

	public static void createUser(String email, String name, String password) throws SQLException {
		DataSource dataSource = getDataSource();
		try(Connection conn = dataSource.getConnection()){
			PreparedStatement statement = conn.prepareStatement("insert into smartdcu.users (email, name, password) values (?, ?, ?)");
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.execute();
		}
		
	}
	
}
