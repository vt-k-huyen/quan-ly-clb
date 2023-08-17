<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang quản trị
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                	<c:if test="${not empty USERMODEL}">
                    	<a data-toggle="dropdown" href="" class="dropdown-toggle">
                    		<i class="fa fa-user"></i>
                       	 ${USERMODEL.userName}
                    	</a>
                    
                    	<li class="light-blue dropdown-modal">
                        	<a href='<c:url value="/doi-matkhau?action=changepass"/>'>
                            	<i class="ace-icon fa fa-key"></i>
                            	Đổi mật khẩu
                        	</a>
                    	</li>
                    	<li class="light-blue dropdown-modal">
                        	<a href='<c:url value="/thoat?action=logout"/>'>
                            	<i class="ace-icon fa fa-sign-out"></i>
                            	Thoát
                        	</a>
                    	</li>
                    </c:if>	
                    <c:if test="${empty USERMODEL}">
                    	<li class="light-blue dropdown-modal">
                        	<a href='<c:url value="/dang-nhap?action=login"/>'>
                            	<i class="ace-icon fa fa-sign-in"></i>
                            	Đăng nhập
                        	</a>
                    	</li>
                    </c:if>
               </li>
            </ul>
        </div>
    </div>
</div>