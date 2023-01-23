package proxima.informatica.academy.seventh.role;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.seventh.service.RoleService;
import proxima.informatica.academy.seventh.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class DeleteUserService
 */
@WebServlet("/DeleteRoleServlet")
public class DeleteRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(DeleteRoleServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRoleServlet() {
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
		String idSelected = request.getParameter("selectedRoleId");
		int id = Integer.parseInt(idSelected);
		boolean result = false;
//		try {
//			deleteRowUsers(id);
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			result = deleteRowRole(id);
			logger.debug("result = "+result);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == true) {
			request.setAttribute("deleteRole","OK");
			request.getRequestDispatcher("roles.jsp").forward(request,response);
		}else {
			request.setAttribute("deleteRole","KO");
			request.getRequestDispatcher("roles.jsp").forward(request,response);
		}
		
		//request.getRequestDispatcher("users.jsp").forward(request,response);
	}
	
	private boolean deleteRowRole(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean value =RoleService.getInstance().deleteRole(id);
		return value;
	}

}
