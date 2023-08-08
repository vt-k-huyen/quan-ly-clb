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
import com.quanlyclb.model.EventModel;
import com.quanlyclb.paging.PageRequest;
import com.quanlyclb.paging.Pageble;
import com.quanlyclb.service.IEventService;
import com.quanlyclb.sort.Sorter;
import com.quanlyclb.utils.FormUltil;

@WebServlet(urlPatterns = {"/admin-event"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEventService eventService;
	
    public EventController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventModel model = FormUltil.toModel(EventModel.class, request);
		String view  = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(eventService.findAll(pageble));
			model.setTotalItem(eventService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/event/list.jsp"; 
		} else if(model.getType().equals(SystemConstant.EDIT)){
			if(model.getEventID() != null) {
				model = eventService.findOne(model.getEventID());
			}
			view = "/views/admin/event/edit.jsp";
		}
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
