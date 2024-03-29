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
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;

@WebServlet(urlPatterns = {"/admin-club"})
public class ClubController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClubService clubService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClubModel model = FormUltil.toModel(ClubModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(clubService.findAll(pageble));
			model.setTotalItem(clubService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/club/list.jsp"; 
		} else if(model.getType().equals(SystemConstant.EDIT)){
			if(model.getClubID() != null) {
				model = clubService.findOne(model.getClubID());
			}
			view = "/views/admin/club/edit.jsp";
		} else if(model.getType().equals(SystemConstant.DELETE)){
			if(model.getClubID() != null) {
				clubService.delete(model.getClubID());
			}
			view = "/admin-club?type=list&page=1&maxPageItem=2&sortName=club_name&sortBy=asc";
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("UTF-8");
				ClubModel model = FormUltil.toModel(ClubModel.class, request);
				if(request.getParameter("btnAdd") !=null) {
					clubService.save(model);	
					response.sendRedirect(request.getContextPath() + "/admin-club?type=list&page=1&maxPageItem=2&sortName=club_name&sortBy=asc");
				}else if(request.getParameter("btnUpdate") !=null) {
					clubService.update(model);
					response.sendRedirect(request.getContextPath() + "/admin-club?type=list&page=1&maxPageItem=2&sortName=club_name&sortBy=asc");
				}
				RequestDispatcher rd = request.getRequestDispatcher("/admin-club?type=list&page=1&maxPageItem=2&sortName=club_name&sortBy=asc");
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
}
