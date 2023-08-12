<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sinh viên</title>
</head>
<body>
<c:url var="apiURL" value="/api-admin-requestlist"/>
<c:url var ="RequestListURL" value="/admin-requestlist"/>
	<div class="main-content">
		<form action="<c:url value='/admin-requestlist'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="/QuanLyCLB/admin-home">Trang
								chủ</a></li>
						<li class="active">Xử lý yêu cầu</li>
						<li class="active">Đăng ký câu lạc bộ</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
						
							<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
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
													<th>Mã sinh viên</th>
													<th>Họ đệm</th>
													<th>Tên</th>
													<th>Tên CLB</th>
													<th>Trạng thái</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult }">
													<tr>
														<td><input type="checkbox" value="${item.requestID}"  id="checkbox_${item.requestID}"></td>
														<td>${item.memberID}</td>
														<c:forEach var="members" items="${members}">
															<c:if test="${members.memberID.equals(item.memberID)}">
																<td>${members.firstName}</td>
																<td>${members.lastName }</td>
															</c:if>
														</c:forEach>
														<c:forEach var="clubs" items="${clubs}">
															<c:if test="${clubs.clubID.equals(item.clubID)}">
																<td>${clubs.clubName}</td>
															</c:if>
														</c:forEach> 
														<c:if test="${item.status == 0}">
															<td>Chưa duyệt</td>
														</c:if>
														<c:if test="${item.status == 1}">
															<td>Thành viên</td>
														</c:if>
														<c:if test="${item.status == 2}">
															<td>Cựu thành viên</td>
														</c:if>
														<td>
															<c:url var="editURL" value="/admin-requestlist">
																<c:param name="type" value="edit"></c:param>
																<c:param name="requestID" value="${item.requestID}"></c:param>
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																title="Xử lý yêu cầu" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															</a>
														</td>
													</tr>
												</c:forEach>
												<span> Có ${model.totalItem} yêu cầu đăng ký trong ${model.totalPage} trang </span>
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
		var limit = 5;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
 						$('#sortName').val('status');
						$('#sortBy').val('asc'); 
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