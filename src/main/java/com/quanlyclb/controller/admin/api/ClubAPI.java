package com.quanlyclb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-club"})
public class ClubAPI extends HttpServlet{
	private static final long serialVersionUID = -22454567L;
	
	@Inject
	private IClubService clubService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ClubModel model = HttpUtil.of(request.getReader()).toModel(ClubModel.class);
		model = clubService.save(model);
		mapper.writeValue(response.getOutputStream(), model);
		response.sendRedirect(request.getContextPath() + "/admin-club");
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ClubModel model = HttpUtil.of(request.getReader()).toModel(ClubModel.class);
		model = clubService.update(model);
		mapper.writeValue(response.getOutputStream(), model);
		response.sendRedirect(request.getContextPath() + "/admin-club");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect(request.getContextPath() + "/admin-club");
	}
}
