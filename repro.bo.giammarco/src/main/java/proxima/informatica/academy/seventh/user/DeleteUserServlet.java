package proxima.informatica.academy.seventh.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.seventh.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class DeleteUserService
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(DeleteUserServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSelected = request.getParameter("selectedUserId");
		int id = Integer.parseInt(idSelected);
		boolean result = false;
//		try {
//			deleteRowUsers(id);
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			result = deleteRowUsers(id);
			logger.debug("result = "+result);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == true) {
			request.setAttribute("deleteUser","OK");
			request.getRequestDispatcher("users.jsp").forward(request,response);
		}else {
			request.setAttribute("deleteUser","KO");
			request.getRequestDispatcher("users.jsp").forward(request,response);
		}
		
		//request.getRequestDispatcher("users.jsp").forward(request,response);
	}
	
	private boolean deleteRowUsers(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean value =UserService.getInstance().deleteUser(id);
		return value;
	}

}
