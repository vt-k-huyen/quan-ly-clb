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
import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IEventService;
import com.quanlyclb.service.IMemberEventService;
import com.quanlyclb.service.IMemberService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;

@WebServlet(urlPatterns = {"/admin-memberevent"})
public class MemberEventController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IMemberEventService meService;
	
	@Inject
	private IMemberService memberService;
	
	@Inject
	private IEventService eventService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MemberEventModel model = FormUltil.toModel(MemberEventModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(meService.findAll(pageble));
			model.setTotalItem(meService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/memberevent/list.jsp"; 
		} else if(model.getType().equals(SystemConstant.EDIT)){
			if(model.getId() != null) {
				model = meService.findOne(model.getId());
			}
			view = "/views/admin/memberevent/edit.jsp";
		}
		request.setAttribute("events", eventService.findAll());
		request.setAttribute("members", memberService.findAll());
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		long id = Long.parseLong(request.getParameter("id"));
		MemberEventModel updateModel = meService.findOne(id);
 		String btnAccept = request.getParameter("btnAccept");
		String btnReject = request.getParameter("btnReject");
		String btnDelete = request.getParameter("btnDelete");
		if (btnAccept != null && updateModel.getStatus() == 0) {
			updateModel = meService.accept(updateModel);
			System.out.println("đã duyệt");
			response.sendRedirect(request.getContextPath()+ "/admin-memberevent?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc");
		} else if(btnReject != null && updateModel.getStatus() == 0) {
			updateModel = meService.reject(updateModel);
			System.out.println("đã từ chối");
			response.sendRedirect(request.getContextPath()+ "/admin-memberevent?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc");
		} else if(btnDelete != null) {
			meService.delete(id);
			System.out.println("đã xóa");
			response.sendRedirect(request.getContextPath()+ "/admin-memberevent?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc");
		}
	}
}
