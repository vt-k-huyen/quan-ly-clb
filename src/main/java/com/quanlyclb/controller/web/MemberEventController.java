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
import com.quanlyclb.model.ClubModel;
import com.quanlyclb.model.EventModel;
import com.quanlyclb.model.MemberEventModel;
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.service.IEventService;
import com.quanlyclb.service.IMemberEventService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/memberevent"})
public class MemberEventController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEventService eventService;
	
	@Inject
	private IClubService clubService;
	
	@Inject
	private IMemberEventService meService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		EventModel model = FormUltil.toModel(EventModel.class, request);
		String view = "";
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String memberID = userModel.getUserID();
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(eventService.findEvents(memberID, pageble));
			model.setTotalItem(model.getListResult().size());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/web/memberevent/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getClubID() != null) {
				model = eventService.findOne(model.getEventID());
			}
			view = "/views/web/memberevent/edit.jsp";
		}else if (model.getType().equals(SystemConstant.INSERT)) {
			MemberEventModel me  = FormUltil.toModel(MemberEventModel.class, request);
			me = meService.save(me);
			view = "/views/web/memberevent/list.jsp";
		}
		request.setAttribute("clubs", clubService.findAll());
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
