<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách câu lạc bộ</title>
</head>
<body>
	<div class="main-content">
		<form action="<c:url value='/event'/>" id="formSubmit" method="get" >
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="/QuanLyCLB/trang-chu">Trang
								chủ</a></li>
						<li class="active">Danh mục</li>
						<li class="active">Hoạt động đã tham gia</li>
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
													<th><input type="checkbox" id="checkAll"></th>
													<th>Mã sinh viên</th>
													<th>Tên hoạt động</th>
													<th>Trạng thái</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult }">
													<tr>
														<td><input type="checkbox" value="${item.id}"  id="checkbox_${item.id}"></td> 
														
														<td>${item.memberID}</td>
														
														<c:forEach var="events" items="${events}">
															<c:if test="${events.eventID.equals(item.eventID)}">
																<td>${events.eventName}</td>
															</c:if>
														</c:forEach>
														
														<c:if test="${item.status == 0}">
															<td>Chờ duyệt</td>
														</c:if>
														<c:if test="${item.status == 1}">
															<td>Đã tham gia</td>
														</c:if>
														<c:if test="${item.status == -1}">
															<td>Đã hủy</td>
														</c:if>
													</tr>
												</c:forEach>
												<span> Đã tham gia ${model.totalItem} hoạt động</span>
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
	</script>
</body>
</html>