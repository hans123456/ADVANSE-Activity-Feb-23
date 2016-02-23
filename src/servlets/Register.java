package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import models.User;
import models.UserDAO;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Subject currentUser = SecurityUtils.getSubject();

			String name = request.getParameter("name");
			String username = request.getParameter("id_num");
			String password = request.getParameter("password");

			User user = new User();

			UserDAO dao = new UserDAO();
			if (dao.create(user)) {
				response.getWriter().print("success");
				System.out.println("Hooray Registered!");
			} else {
				response.getWriter().print("fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
