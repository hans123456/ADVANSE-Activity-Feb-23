package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.UserDAO;
import shiro.ShiroPasswordManager;

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

			String name = request.getParameter("fullname");
			String username = request.getParameter("id_num");
			String password = request.getParameter("password");

			User user = new User();
			user.setInfo("name", name);
			user.setInfo("id_num", username);
			user.setInfo("password", ShiroPasswordManager.encryptPassword(password));

			UserDAO dao = new UserDAO();
			if (dao.create(user)) {
				response.getWriter().print("Hooray Registered!");
			} else {
				response.getWriter().print("Id Num Already Registered.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
