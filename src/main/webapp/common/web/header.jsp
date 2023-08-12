<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Trang chủ
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                	<c:if test="${not empty USERMODEL}">
                    	<a data-toggle="dropdown" href="#" class="dropdown-toggle">
                       	 Xin chào, ${USERMODEL.userName}
                    	</a>
                    
                    	<li class="light-blue dropdown-modal">
                        	<a href='<c:url value="/thoat?action=logout"/>'>
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
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Trang chủ
                <span class="sr-only">(current)</span>
              </a>
            </li>
            
            <c:if test="${not empty USERMODEL}">
              <li class="nav-item">
                <a class="nav-link" href='#'>Wellcome, ${USERMODEL.userName}</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/thoat?action=logout"/>'>Thoát</a>
              </li>
            </c:if>
            <c:if test="${empty USERMODEL}">
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a>
              </li>
            </c:if>
            
          </ul>
        </div> 
      </div>
</nav> --%>