<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tham gia hoạt động</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/memberclub'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="/QuanLyCLB/trang-chu">Trang
								chủ</a></li>
						<li class="active">Đăng ký</li>
						<li class="active">Tham gia hoạt động</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
						
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Hoạt động</th>
													<th>Bắt đầu</th>
													<th>Kết thúc</th>
													<th>Chi tiết </th>
													<th>Câu lạc bộ</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult }">
													<tr>
														<td>${item.eventName}</td>
														<td>${item.fromDate}</td>
														<td>${item.toDate}</td>
														<td>${item.detail}</td>
														<c:forEach var="clubs" items="${clubs }">
															<c:if test="${item.clubID.equals(clubs.clubID)}">
																<td>${clubs.clubName}</td>
															</c:if>
														</c:forEach>
														<td>
															<c:url var="editURL" value="/memberevent">
																<c:param name="type" value="insert"></c:param>
																<c:param name="memberID" value="${USERMODEL.userID }"></c:param>
																<c:param name="eventID" value="${item.eventID}"></c:param>
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Tham gia"
															href='${editURL}'><i class="fa fa-bookmark"
																aria-hidden="true"></i> </a></td>
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