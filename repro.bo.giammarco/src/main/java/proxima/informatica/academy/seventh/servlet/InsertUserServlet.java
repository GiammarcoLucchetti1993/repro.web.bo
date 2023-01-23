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
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(InsertUserServlet.class);

	/**
	 * Default constructor.
	 */
	public InsertUserServlet() {
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
		String email = request.getParameter("email_input");
		String password = request.getParameter("password_input");
		String firstName = request.getParameter("firstname_input");
		String lastName = request.getParameter("lastname_input");
		String birthDate = request.getParameter("birthdate_input");
//		String role = request.getParameter("role_input");		
//		int rowsUpdate=0;
		boolean value = false;
		
		try {
			//rowsUpdate = insertNewUser(email,password,firstName,lastName,birthDate);
			value = insertNewUsers(email,password,firstName,lastName,birthDate);
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (value == true) {
				request.getRequestDispatcher("users.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("insertUser.jsp").forward(request, response);
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean insertNewUsers(String email, String password, String firstName, String lastName,
			String birthDate)
					throws ClassNotFoundException, SQLException, IOException, ParseException {
		boolean value = false;
		UserDto userToInsert = new UserDto();
		Timestamp userInsertedTime = Timestamp.valueOf(LocalDateTime.now());
		Date date = Date.valueOf(birthDate);
		int role = 10;
		userToInsert.setEmail(email);
		userToInsert.setPassword(password);
		userToInsert.setFirstName(firstName);
		userToInsert.setLastName(lastName);
		userToInsert.setDateOfBirth(date);
		userToInsert.setRegDate(userInsertedTime);
		userToInsert.setRole(role);
		value = UserService.getInstance().insertUser(userToInsert);
		
		return value;
	}
}
