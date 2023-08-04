 package com.quanlyclb.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.security.GetContextClassLoaderAction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyclb.constant.SystemConstant;
import com.quanlyclb.model.AnnouncementModel;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IAnnouncementService;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/admin-announcement"})
public class AnnouncementController extends HttpServlet{
	private static final long serialVersionUID = 2686801510274002166L;

	@Inject
	private IAnnouncementService announcementService;
	
	@Inject
	private IClubService clubService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AnnouncementModel model = FormUltil.toModel(AnnouncementModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(announcementService.findAll(pageble));
			model.setTotalItem(announcementService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/announcement/list.jsp"; 
		} else if(model.getType().equals(SystemConstant.EDIT)){
			if(model.getAnnouncementID() != null) {
				model = announcementService.findOne(model.getAnnouncementID());
			}
			request.setAttribute("clubs", clubService.findAll());
			view = "/views/admin/announcement/edit.jsp";	
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		System.out.print(123);
		String id = request.getParameter("announcementID");
		String clubId = request.getParameter("clubID");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String note = request.getParameter("note");
		String btnSave = request.getParameter("btnAddOrUpdateTB");  
		if(id != null && btnSave.equals("Cập nhật thông báo")) {
			AnnouncementModel model = new AnnouncementModel(Long.parseLong(id), title, content, clubId, null, null,
					note);
			List<AnnouncementModel> list = announcementService.findAll();
			request.setAttribute("listTB", list);
			response.getWriter().print(model.toString());
			System.out.print(model.toString());
			model = announcementService.save(model);
			request.setAttribute("listTB", list);
			request.setAttribute(SystemConstant.MODEL, model);
			response.sendRedirect(request.getContextPath() + "/admin-announcement");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/announcement/edit.jsp");
		rd.forward(request, response);
	}
}
