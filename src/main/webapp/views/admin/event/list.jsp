<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách hoạt động</title>
</head>
<body>
<c:url var="apiURL" value="/api-admin-event"/>
<c:url var ="EventURL" value="/admin-event"/>
	<div class="main-content">
		<form action="<c:url value='/admin-event'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
						<li class="active">Danh sách hoạt động</li>
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
											data-toggle="tooltip" title='Thêm hoạt động'
											href='<c:url value="/admin-event?type=edit"/>'> <span>
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
													<th>Mã hoạt động</th>
													<th>Tên hoạt động</th>
													<th>Chi tiết</th>
													<th>Mã CLB</th>
													<th>Bắt đầu</th>
													<th>Kết thúc</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult }">
													<tr>
														<td><input type="checkbox" value="${item.eventID}"  id="checkbox_${item.eventID}"></td>
														<td>${item.eventID}</td>
														<td>${item.eventName}</td>
														<td>${item.detail}</td>
														<td>${item.clubID}</td>
														<td>${item.fromDate}</td>
														<td>${item.toDate}</td>
														<td>
															<c:url var="editURL" value="/admin-event">
																<c:param name="type" value="edit"></c:param>
																<c:param name="eventID" value="${item.eventID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Cập nhật" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															</a>
															<c:url var="deleteURL" value="/admin-event">
																<c:param name="type" value="delete"></c:param>
																<c:param name="eventID" value="${item.eventID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Xóa" href='${deleteURL}'><i class="fa fa-trash-o" aria-hidden="true"></i>
															</a>
														</td>
													</tr>
												</c:forEach>
												<span> Có ${model.totalItem} hoạt động trong ${model.totalPage} trang </span>
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
 						$('#sortName').val('event_id');
						$('#sortBy').val('desc'); 
						$('#type').val('list'); 
						$('#formSubmit').submit();
					}	
				}
			});
		});
		$("btnDelete").click(function(){
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
	            return $(this).val();
			 }).get();
			data['ids'] = ids;
			deleteClub(data);
		});
		function deleteClub(data){
			$.ajax({
				url: '${apiURL}',
				type: 'DELETE', 
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result){
					  window.location.href = "$(EventURL)?type=list&maxPageItem=2&page=1";
				},
				error: function(error){
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>