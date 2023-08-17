package com.quanlyclb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quanlyclb.constant.SystemConstant;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IAnnouncementService;
import com.quanlyclb.service.IUserService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {

	@Inject
	private IUserService userService;
	
	@Inject
	private IAnnouncementService announcementService;
	
	private static final long serialVersionUID = 166L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
				SessionUtil.getInstance().removeValue(request, "USERMODEL");
				/* response.sendRedirect(request.getContextPath() + "/trang-chu"); */
					RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
					rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUltil.toModel(UserModel.class, request);
			model = userService.findByEmail_Password_Status(model.getEmail(), model.getPassword(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if (model.getRole().getRoleID().equals("USER")) {
					 response.sendRedirect(request.getContextPath() + "/trang-chu");
					 
				} else if (model.getRole().getRoleID().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}

			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=email_password_invalid&alert=danger");
			}
		}

	}
}
