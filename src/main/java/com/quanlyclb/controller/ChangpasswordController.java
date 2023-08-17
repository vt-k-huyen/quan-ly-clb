package com.quanlyclb.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quanlyclb.model.UserModel;
import com.quanlyclb.service.IUserService;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/doi-matkhau"})
public class ChangpasswordController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("changepass")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/changepass.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			String oldPass = request.getParameter("oldpass");
			System.out.println(oldPass);
			if (oldPass != null && oldPass.equals(model.getPassword()) == false) {
				response.sendRedirect(request.getContextPath()
						+ "/doi-matkhau?action=changepass&message=oldpassword_invalid&alert=danger");
			}
			String newPass = request.getParameter("newpass");
			System.out.println("newpass="+ newPass );

			if (newPass != null && newPass.equals(model.getPassword())) {
				response.sendRedirect(request.getContextPath()
						+ "/doi-matkhau?action=changepass&message=newpassword_invalid&alert=danger");
			}

			String userID = model.getUserID();
			System.out.println(userID);
			userService.ChangePassword(userID, newPass);
			System.out.println("đổi mật khẩu");
			response.sendRedirect(request.getContextPath() +"/thoat?action=logout"); 
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("/thoat?action=logout");
			 * rd.forward(request, response);
			 */
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
