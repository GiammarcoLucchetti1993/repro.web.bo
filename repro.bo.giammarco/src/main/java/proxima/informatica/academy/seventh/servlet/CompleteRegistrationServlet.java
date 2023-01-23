package proxima.informatica.academy.seventh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.proxima.common.mail.MailUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class completeRegistrationServlet
 */
@WebServlet("/CompleteRegistrationServlet")
public class CompleteRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(CompleteRegistrationServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id_input"));
		String password = request.getParameter("password_input");
		String confirmPassword = request.getParameter("confirmpassword_input");
		if (password.equalsIgnoreCase(confirmPassword)) {
			try {
				// rowsUpdate = insertNewUser(email,password,firstName,lastName,birthDate);
				if (setPassword(id, password)) {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				};
			} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("insertPassword","KO");
			request.getRequestDispatcher("completeRegistration.jsp?id=" + id +"").forward(request, response);
		};
		
		
	}
	
	private boolean setPassword(int id,String password) throws ClassNotFoundException, ParseException, IOException, SQLException {
		boolean result = false;
		int value= 0;
		UserDto user = new UserDto();
		user = UserService.getInstance().selectUserById(id);
		user.setPassword(password);
		value = UserService.getInstance().updateUser(id, user);
		int roleAdmin = 0;
		if(value >0) {
			ArrayList<UserDto> users = new ArrayList<UserDto>();
			users = UserService.getInstance().selectAllAdminByRole(roleAdmin);
			logger.debug(""+users);
			String[] email = new String[users.size()];
			String objectEmail = "Attiva User";
			String message="<p>Clicca questo <a href ='http://localhost:8080/repro.bo.giammarco/updateUser.jsp?selectedUserId="+user.getId()+"'>link </a>per attivare l'utente</p>";
			for(int i = 0 ; i< users.size() ; i++) {
				email[i] = users.get(i).getEmail();
			}
			MailUtility.sendSimpleMail(email,objectEmail,message);
			result = true;
		}
		return result;
	}

}
