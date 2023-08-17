package com.quanlyclb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quanlyclb.constant.SystemConstant;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IAnnouncementService;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;

@WebServlet(urlPatterns = {"/announcement"})
public class AnnouncementController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAnnouncementService announcementService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AnnouncementModel model = FormUltil.toModel(AnnouncementModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(announcementService.findAll(pageble));
			model.setTotalItem(announcementService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/web/announcement/list.jsp"; 
		} if(model.getType().equals(SystemConstant.DETAIL)) {
			if(model.getAnnouncementID() != null) {
				model = announcementService.findOne(model.getAnnouncementID());
			}
			view = "/views/web/announcement/detail.jsp";	
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
