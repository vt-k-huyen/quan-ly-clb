package com.quanlyclb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.service.IRequestListService;
import com.quanlyclb.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-requestlist"})
public class RequestListAPI extends HttpServlet{
	
	private static final long serialVersionUID = -22454567L;
	
	@Inject
	private IRequestListService requestListService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); 
		// dinh nghia ket qua tra ve json
		// Chuyen du lieu truyen vao sang Model
		RequestListModel model = HttpUtil.of(request.getReader()).toModel(RequestListModel.class);
		// model.setCreateBy(((UserModel)
		// SessionUtil.getInstance().getValue(request,"USERMODEL")).getUserName());
		response.getWriter().print(model.toString());
		System.out.print(model.toString());
		model = requestListService.save(model);
		mapper.writeValue(response.getOutputStream(), model);
		response.sendRedirect(request.getContextPath() + "/admin-announcement");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String accept = request.getParameter("btnAccept");
		String finish = request.getParameter("btnFinish");
		System.out.print(accept);
		System.out.print(finish);
		RequestListModel updateModel = HttpUtil.of(request.getReader()).toModel(RequestListModel.class);
		if(accept != null ) {
			updateModel = requestListService.accept(updateModel);
		} else if(finish != null ){
			 updateModel = requestListService.finish(updateModel);
		}
		System.out.print(updateModel.toString() + "update");
		updateModel = requestListService.accept(updateModel);
		mapper.writeValue(response.getOutputStream(), updateModel);
		response.sendRedirect(request.getContextPath() + "/admin-announcement");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		AnnouncementModel deleteModel = HttpUtil.of(request.getReader()).toModel(AnnouncementModel.class);
		/* requestListService.delete(deleteModel.getIds()); */
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
