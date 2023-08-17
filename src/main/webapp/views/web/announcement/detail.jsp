<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<c:url var="apiURL" value="/api-admin-announcement"/>
<c:url var ="AnnouncementURL" value="/admin-announcement"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông báo</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/announcement'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
						<li class="active">Danh mục</li>
						<li class="active">Thông báo</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<h2>THÔNG BÁO</h2>
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12">
										<p>
											<strong>${model.title}</strong> 
											<br /> 
											<small class="text-muted">${model.createDate}</small>
										</p>
										<p>${model.content}</p>
										<p></p>
										<p>&nbsp;</p>
									</div>
								</div>
							</div>
							<%-- <div class="row">
								<div class="col-xs-12">
								<div class="table-responsive">
										<c:forEach var="item" items="${model.listResult}">
											<div style="margin-bottom: 15px">
												<p style="font-weight: bold">
													<a href='<c:url value="#"></c:url>'>${item.title } </a> <br />
													<small class="text-muted">[${item.createDate}]</small>
												</p>
												<p>${item.content}</p>
											</div>
										</c:forEach>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" />
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
 										<input type="hidden" value="" id="sortName" name="sortName" />
										<input type="hidden" value="" id="sortBy" name="sortBy" />
										<input type="hidden" value="" id="type" name="type" />
								</div>
								</div>
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
</body>
</html>