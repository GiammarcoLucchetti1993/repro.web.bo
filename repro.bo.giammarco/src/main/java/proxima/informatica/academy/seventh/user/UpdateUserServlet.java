package proxima.informatica.academy.seventh.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.service.UserService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class DeleteUserService
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(UpdateUserServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSelected = request.getParameter("id_input");
		logger.debug(idSelected);
		int id = Integer.parseInt(idSelected);
		int result = 0;
		String email = request.getParameter("email_input");
		String password = request.getParameter("password_input");
		String firstName = request.getParameter("firstname_input");
		String lastName = request.getParameter("lastname_input");
		String birthDate = request.getParameter("birthdate_input");
		String regDate = request.getParameter("regdate_input");
		String role = request.getParameter("role_input");
		String imgPath = request.getParameter("imgpath_input");
		String note = request.getParameter("note_input");
		String enabled = request.getParameter("enabled_input");
		
		try {
			result = updateUser(id,email,password,firstName,lastName,birthDate,regDate,role,imgPath,note,enabled);
			logger.debug("result = "+result);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {	
			request.setAttribute("updateUser","OK");
			request.getRequestDispatcher("users.jsp").forward(request,response);
		}else {
			request.setAttribute("updateUser","KO");
			request.getRequestDispatcher("users.jsp").forward(request,response);
		}
		
		//request.getRequestDispatcher("users.jsp").forward(request,response);
	}
	
	private int updateUser(int id,String email,String password,String firstName,String lastName,String birthDate,
			String regDate,String role,String imgPath,String note,String enabled) throws ClassNotFoundException, SQLException, IOException {
		int value = 0;
		UserDto userToInsert = new UserDto();
		Timestamp userInsertedTime = Timestamp.valueOf(LocalDateTime.now());
		Date date = Date.valueOf(birthDate);
		int roleInsert = Integer.parseInt(role);
		boolean enabledUser;
		int enabledInsert = Integer.parseInt(enabled);
		if(enabledInsert == 0) {
			enabledUser = false;
		}else {
			enabledUser = true;
		}
		userToInsert.setEmail(email);
		userToInsert.setPassword(password);
		userToInsert.setFirstName(firstName);
		userToInsert.setLastName(lastName);
		userToInsert.setDateOfBirth(date);
		userToInsert.setRegDate(userInsertedTime);
		userToInsert.setRole(roleInsert);
		userToInsert.setImgPath(imgPath);
		userToInsert.setNote(note);
		userToInsert.setEnabled(enabledUser);
		value = UserService.getInstance().updateUser(id, userToInsert);
		return value;
	}
}
