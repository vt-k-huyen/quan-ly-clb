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
import com.quanlyclb.model.RequestListModel;
import com.quanlyclb.model.UserModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IClubService;
import com.quanlyclb.service.IRequestListService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;
import com.quanlyclb.utils.SessionUtil;

@WebServlet(urlPatterns = {"/memberclub"})
public class MemberClubController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClubService clubService;
	
	@Inject
	private IRequestListService requestService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClubModel model = FormUltil.toModel(ClubModel.class, request);
		String view = "";
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String memberID = userModel.getUserID();
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(clubService.findClubs(memberID, pageble));
			model.setTotalItem(model.getListResult().size());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/web/memberclub/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getClubID() != null) {
				model = clubService.findOne(model.getClubID());
			}
			view = "/views/web/memberclub/edit.jsp";
		}else if (model.getType().equals(SystemConstant.INSERT)) {
			RequestListModel rq  = FormUltil.toModel(RequestListModel.class, request);
			rq = requestService.save(rq);
			view = "/views/web/memberclub/list.jsp";
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
