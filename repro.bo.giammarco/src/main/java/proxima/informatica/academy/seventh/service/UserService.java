package proxima.informatica.academy.seventh.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.proxima.common.mail.MailUtility;
//import org.proxima.common.mail.MailUtility;
import org.slf4j.LoggerFactory;

import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.login.LoginResult;

public class UserService {

	private static UserService instance;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

	private UserService() {
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public boolean login(String email, String password) {
		boolean responseValue = false;
		UserDto userRetrieved;
		try {
			userRetrieved = DatabaseManagerSingleton.getInstance().getUser(email, password);
			responseValue = userRetrieved != null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseValue;
	}

	public boolean insertUser(UserDto userToInsert) throws ClassNotFoundException, SQLException, IOException {
		boolean responseValue = false; 
		int rowChange = DatabaseManagerSingleton.getInstance().insertUser(userToInsert);
		String email = userToInsert.getEmail();
		UserDto user = DatabaseManagerSingleton.getInstance().selectByEmail(email);
		String objectEmail = "Conferma Registrazione";
		String message="<p>Clicca questo <a href ='http://localhost:8080/repro.bo.giammarco/completeRegistration.jsp?id="+user.getId()+"'>link </a>per completare la registrazione</p>";
		if(rowChange>0)
		{
			try {
			MailUtility.sendSimpleMail(email,objectEmail,message);
			}catch(Exception e) {
				//e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
			responseValue = true;
		}
		return responseValue;
	}

	public ArrayList<UserDto> selectAllUsers() throws ParseException, IOException, ClassNotFoundException, SQLException {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		users = DatabaseManagerSingleton.getInstance().selectAllUsers();
		return users;
	}
	
	public ArrayList<UserDto> selectAllAdminByRole(int role) throws ParseException, IOException, ClassNotFoundException, SQLException {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		users = DatabaseManagerSingleton.getInstance().selectAllAdminByRole(role);
		return users;
	}
	
	public boolean deleteUser(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean value = DatabaseManagerSingleton.getInstance().deleteRowUsers(id);
		return value;
	}
	
	public UserDto selectUserById(int id) throws ParseException, IOException, ClassNotFoundException, SQLException {
		UserDto users = new UserDto();
		users = DatabaseManagerSingleton.getInstance().selectByUserId(id);
		return users;
	}
	
	public int updateUser(int id,UserDto userUpdate) {
		int value = DatabaseManagerSingleton.getInstance().updateUser(id, userUpdate);
		return value;
	}
	
	public UserDto selectUserByEmail(String email) {
		UserDto user = new UserDto();
		user = DatabaseManagerSingleton.getInstance().selectByEmail(email);
		return user;
	}
	
	public LoginResult loginServlet(String email,String password) {
		LoginResult result = new LoginResult();
		UserDto user = new UserDto();
		user = DatabaseManagerSingleton.getInstance().getUser(email, password);
		System.out.println(user);
		if(user.getEmail() == null || user.getPassword()==null) {
			logger.debug("sto qui dentro");
			result.setLoginMessage("Email o Password Errati");
			result.setLoginResponse(false);
		}
		else if(user.getEnabled() == false) {
			result.setLoginMessage("Non sei abilitato");
			result.setLoginResponse(false);
		}
		else {
			result.setLoginResponse(true);
		}
		return result;
	}
}
