package proxima.informatica.academy.seventh.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.service.RoleService;
import proxima.informatica.academy.seventh.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/InsertRoleServlet")
public class InsertRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(InsertRoleServlet.class);

	/**
	 * Default constructor.
	 */
	public InsertRoleServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("do get start");
//		System.out.println(request.getParameter("username"));
//		System.out.println(request.getParameter("password"));
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String label = request.getParameter("label_input");
		String description = request.getParameter("description_input");
		String level = request.getParameter("level_input");
		boolean value = false;
		
		try {
			//rowsUpdate = insertNewUser(email,password,firstName,lastName,birthDate);
			value = insertNewRole(label,description,level);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (value == true) {
				request.getRequestDispatcher("roles.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("insertRole.jsp").forward(request, response);
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean insertNewRole(String label, String description, String level)throws ClassNotFoundException, SQLException, IOException, ParseException {
		boolean value = false;
		RoleDto roleToInsert = new RoleDto();
		int levelInserted = Integer.parseInt(level);
		roleToInsert.setLabel(label);
		roleToInsert.setDescription(description);
		roleToInsert.setLevel(levelInserted);
		value = RoleService.getInstance().insertRole(roleToInsert);
		return value;
	}
}
