<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký câu lạc bộ</title>
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
						<li class="active">Câu lạc bộ</li>
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
													<th>Mã CLB</th>
													<th>Tên CLB</th>
													<th>Mô tả</th>
													<th>Ngày thành lập</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${model.totalItem != 0}">
													<c:forEach var="item" items="${model.listResult }">
														<tr>
															<td>${item.clubID}</td>
															<td>${item.clubName}</td>
															<td>${item.description}</td>
															<td>${item.createDate}</td>
															<td>
																<c:url var="editURL" value="/memberclub">
																	<c:param name="type" value="insert"></c:param>
																	<c:param name="memberID" value="${USERMODEL.userID }"></c:param>
																	<c:param name="clubID" value="${item.clubID }"></c:param>
																</c:url> <a class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Đăng ký" href='${editURL}'><i
																	class="fa fa-bookmark" aria-hidden="true"></i> 
																	</a>
															</td>
														</tr>
													</c:forEach>
													<span> Có ${model.totalItem} câu lạc bộ trong ${model.totalPage} trang</span>
												</c:if>
												<c:if test="${model.listResult.size() == 0}">
													<span> Không có câu lạc bộ nào được đăng ký</span>
												</c:if>
												
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
 						$('#sortName').val('club_name');
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