package com.quanlyclb.controller.admin.api;


import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.service.IAnnouncementService;
import com.quanlyclb.utils.HttpUtil;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-announcement"})
public class AnnouncementAPI {
	private static final long serialVersionUID = -915988021506484384L;
	
	@Inject
	private IAnnouncementService announcementService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//dinh nghia ket  qua tra ve json
		// Chuyen du lieu truyen vao sang Model
		AnnouncementModel model = HttpUtil.of(request.getReader()).toModel(AnnouncementModel.class);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		model.setCreateBy(userModel.getUserName());
		//model.setCreateBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		model = announcementService.save(model);
		mapper.writeValue(response.getOutputStream(), model);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		AnnouncementModel updateModel = HttpUtil.of(request.getReader()).toModel(AnnouncementModel.class);
		updateModel = announcementService.update(updateModel);
		mapper.writeValue(response.getOutputStream(), updateModel);	
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		AnnouncementModel deleteModel = HttpUtil.of(request.getReader()).toModel(AnnouncementModel.class);
		announcementService.delete(deleteModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}

