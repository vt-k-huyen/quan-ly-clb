<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiURL" value="/api-admin-club"/>
<c:url var ="ClubURL" value="/admin-club"/>
<!DOCTYPE html>
<html>
<head>
<c:url var="apiURL" value="/api-admin-club"/>
<c:url var ="ClubURL" value="/admin-club"/>
<meta charset="UTF-8">
<title>Danh sách câu lạc bộ</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/admin-club'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
						<li class="active">Danh mục</li>
						<li class="active">Danh sách câu lạc bộ</li>
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
											data-toggle="tooltip" title='Thêm câu lạc bộ'
											href='<c:url value="/admin-club?type=edit"/>'> <span>
												<i class="fa fa-plus-circle"></i>
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
													<th>Mã CLB</th>
													<th>Tên CLB</th>
													<th>Giới thiệu</th>
													<th>Ngày thành lập</th>
													<th>Ngày giải thể</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult }">
													<tr>
														<td><input type="checkbox" value="${item.clubID}"  id="checkbox_${item.clubID}"></td>
														<td>${item.clubID}</td>
														<td>${item.clubName}</td>
														<td>${item.description}</td>
														<td>${item.createDate}</td>
														<td>${item.dissolutionDate}</td>
														<td>
															<c:url var="editURL" value="/admin-club">
																<c:param name="type" value="edit"></c:param>
																<c:param name="clubID" value="${item.clubID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Cập nhật" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															</a>
															<c:url var="deleteURL" value="/admin-club">
																<c:param name="type" value="delete"></c:param>
																<c:param name="clubID" value="${item.clubID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Xóa" href='${deleteURL}'><i class="fa fa-trash-o" aria-hidden="true"></i>
															</a>
														</td>
													</tr>
												</c:forEach>
												<span> Có ${model.totalItem} câu lạc bộ trong ${model.totalPage} trang </span>
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
 						$('#sortName').val('club_name');
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