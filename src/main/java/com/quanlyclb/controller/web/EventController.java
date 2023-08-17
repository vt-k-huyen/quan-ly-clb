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
import com.quanlyclb.mapper.MemberEventMapper;
import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IEventService;
import com.quanlyclb.service.IMemberEventService;
import com.quanlyclb.service.IMemberService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/event"})
public class EventController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private IMemberEventService meService;
	
	@Inject
	private IEventService eventService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MemberEventModel model = FormUltil.toModel(MemberEventModel.class, request);
		String view = "";
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String memberID = userModel.getUserID();
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(meService.findEvents(memberID, pageble));
			model.setTotalItem(meService.count(memberID, pageble));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/web/event/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = meService.findOne(model.getId());
			}
			view = "/views/web/event/edit.jsp";
		}
		request.setAttribute("events", eventService.findAll());
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
