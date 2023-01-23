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

import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;

public class RoleService {

	private static RoleService instance;

	private RoleService() {
	}

	public static RoleService getInstance() {
		if (instance == null) {
			instance = new RoleService();
		}
		return instance;
	}
	
	public boolean insertRole(RoleDto userToInsert) throws ClassNotFoundException, SQLException, IOException {
		boolean responseValue = false; 
		int rowChange = DatabaseManagerSingleton.getInstance().insertRole(userToInsert);
		if(rowChange>0)
		{
			responseValue = true;
		}
		return responseValue;
	}
	
	public ArrayList<RoleDto> selectAllRoles() throws ParseException, IOException, ClassNotFoundException, SQLException {
		ArrayList<RoleDto> roles = new ArrayList<RoleDto>();
		roles = DatabaseManagerSingleton.getInstance().selectAllRoles();
		return roles;
	}
	
	public boolean deleteRole(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean value = DatabaseManagerSingleton.getInstance().deleteRowRoles(id);
		return value;
	}
	
	public RoleDto selectRoleById(int id) throws ParseException, IOException, ClassNotFoundException, SQLException {
		RoleDto role = new RoleDto();
		role = DatabaseManagerSingleton.getInstance().selectByRoleId(id);
		return role;
	}
	
	public int updateRole(int id,RoleDto roleUpdate) {
		int value = DatabaseManagerSingleton.getInstance().updateRole(id, roleUpdate);
		return value;
	}
}
