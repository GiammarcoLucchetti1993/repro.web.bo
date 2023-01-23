package proxima.informatica.academy.seventh.role;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.dto.RoleDto;
import proxima.informatica.academy.dto.UserDto;
import proxima.informatica.academy.seventh.service.RoleService;
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
@WebServlet("/UpdateRoleServlet")
public class UpdateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(UpdateRoleServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoleServlet() {
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
		String label = request.getParameter("label_input");
		String description = request.getParameter("description_input");
		String level = request.getParameter("level_input");
		
		try {
			result = updateRole(id,label,description,level);
			logger.debug("result = "+result);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {	
			request.setAttribute("updateRole","OK");
			request.getRequestDispatcher("roles.jsp").forward(request,response);
		}else {
			request.setAttribute("updateRole","KO");
			request.getRequestDispatcher("roles.jsp").forward(request,response);
		}
		
		//request.getRequestDispatcher("users.jsp").forward(request,response);
	}
	
	private int updateRole(int id,String label,String description,String level) throws ClassNotFoundException, SQLException, IOException {
		int value = 0;
		RoleDto roleToInsert = new RoleDto();
		int levelInsert = Integer.parseInt(level);
		roleToInsert.setLabel(label);
		roleToInsert.setDescription(description);
		roleToInsert.setLevel(levelInsert);
		value = RoleService.getInstance().updateRole(id, roleToInsert);
		return value;
	}
}
