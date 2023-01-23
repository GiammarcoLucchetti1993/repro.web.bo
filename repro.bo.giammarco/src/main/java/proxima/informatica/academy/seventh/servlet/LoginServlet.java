package proxima.informatica.academy.seventh.servlet;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.login.LoginResult;
import proxima.informatica.academy.seventh.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("do get start");
//		System.out.println(request.getParameter("username"));
//		System.out.println(request.getParameter("password"));
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LoginResult result = UserService.getInstance().loginServlet(email, password);

		if (result.isLoginResponse()) {
			request.getSession().setAttribute("userLoggedEmail", email);
			request.setAttribute("loginMessage", "Utente correttamente collegato");
			request.getRequestDispatcher("users.jsp").forward(request, response);
		} else {
			request.setAttribute("loginFailure", result.getLoginMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
//		try {
//			if(UserService.getInstance().login(email, password)) {
//				request.getSession().setAttribute("userLoggedEmail", email);
//				request.setAttribute("loginMessage","Utente correttamente collegato");
//				logger.debug("Setto l attribute userLoggedEmail : " + (String) request.getSession().getAttribute("userLoggedEmail"));
//				request.getRequestDispatcher("users.jsp").forward(request,response);
//			}else {
//				request.getRequestDispatcher("login.jsp").forward(request,response);
//			}
//		} catch (IOException | ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
