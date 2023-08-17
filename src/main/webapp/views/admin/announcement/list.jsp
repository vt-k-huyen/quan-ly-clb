<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<c:url var="apiURL" value="/api-admin-announcement"/>
<c:url var ="AnnouncementURL" value="/admin-announcement"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách thông báo</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/admin-announcement'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
						<li class="active">Danh mục</li>
						<li class="active">Danh sách thông báo</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<a flag="info" class="btn btn-sm btn-primary btn-edit"
											data-toggle="tooltip" title='Thêm thông báo'
											href='<c:url value="/admin-announcement?type=edit"/>'> <span>
												<i class="fa fa-plus-circle "></i>
										</span>
										</a>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
												<th><input type="checkbox" id="checkAll"></th>
													<th>Tiêu đề</th>
													<th>Nội dung</th>
													<th>Câu lạc bộ</th>
													<th>Thời điểm viết</th>
													<th>Người viết</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult }">
													<tr>
														<td><input type="checkbox" value="${item.announcementID}"  id="checkbox_${item.announcementID}"></td>
														<td>${item.title}</td>
														<td>${item.content}</td>
														<td>${item.clubID}</td>
														<td>${item.createDate}</td>
														<td>${item.createBy}</td>
														<td>
															<c:url var="editURL" value="/admin-announcement">
																<c:param name="type" value="edit"></c:param>
																<c:param name="announcementID" value="${item.announcementID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Cập nhật thông báo" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															</a>
															<c:url var="deleteURL" value="/admin-announcement">
																<c:param name="type" value="delete"></c:param>
																<c:param name="announcementID" value="${item.announcementID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Xóa" href='${deleteURL}'><i class="fa fa-trash-o" aria-hidden="true"></i>
															</a>
														</td>
													</tr>
												</c:forEach>
												<span> Có ${model.totalItem} thônng báo trong ${model.totalPage} trang </span>
											</tbody>
											
										</table>
										
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" />
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
 										<input type="hidden" value="" id="sortName" name="sortName" />
										<input type="hidden" value="" id="sortBy" name="sortBy" />
										<input type="hidden" value="" id="type" name="type" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script> 
		var totalPage = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
 						$('#sortName').val('title');
						$('#sortBy').val('asc'); 
						$('#type').val('list'); 
						$('#formSubmit').submit();
					}	
				}
			});
		});
	</script>
	
</body>
</html>