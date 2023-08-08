package com.quanlyclb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quanlyclb.constant.SystemConstant;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IUserService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	IUserService userService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UserModel model = FormUltil.toModel(UserModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(userService.findAll(pageble));
			model.setTotalItem(userService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/user/list.jsp"; 
		} else if(model.getType().equals(SystemConstant.EDIT)){
			if(model.getUserID() != null) {
				model = userService.findOne(model.getUserID());
			}
			view = "/views/admin/user/edit.jsp";
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
