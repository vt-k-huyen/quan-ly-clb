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
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.service.IMemberService;
import com.quanlyclb.service.IRequestListService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;

@WebServlet(urlPatterns = {"/admin-requestlist"})
public class RequestListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IRequestListService requestListService;
	
	@Inject
	private IClubService clubService;
	
	@Inject
	private IMemberService memberService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestListModel model = FormUltil.toModel(RequestListModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(requestListService.findAll(pageble));
			model.setTotalItem(requestListService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/requestlist/list.jsp"; 
		} else if(model.getType().equals(SystemConstant.EDIT)){
			if(model.getRequestID() != null) {
				model = requestListService.findOne(model.getRequestID());
			}
			view = "/views/admin/requestlist/edit.jsp";
		}
		request.setAttribute("clubs", clubService.findAll());
		request.setAttribute("members", memberService.findAll());
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		long requestID = Long.parseLong(request.getParameter("requestID"));
		RequestListModel updateModel = requestListService.findOne(requestID);
		String accept = request.getParameter("btnAccept");
		String finish = request.getParameter("btnFinish");
		String delete = request.getParameter("btnDelete"); 
		if(accept != null && updateModel.getStatus() == 0 ) {
			updateModel = requestListService.accept(updateModel);
			response.sendRedirect(request.getContextPath()+ "/admin-requestlist?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc");
		} else if(finish != null && updateModel.getStatus() == 1 ){
			 updateModel = requestListService.finish(updateModel);
			 response.sendRedirect(request.getContextPath()+ "/admin-requestlist?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc");
		} else if (delete != null &&( updateModel.getStatus() == 2|| updateModel.getStatus() == 1)) {
			requestListService.deleteOne(requestID);
			response.sendRedirect(request.getContextPath()+ "/admin-requestlist?type=list&page=1&maxPageItem=5&sortName=status&sortBy=asc");
		}
	}
}
