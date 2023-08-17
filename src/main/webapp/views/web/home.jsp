<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						
					</div>
				</div>
			</div>
			<ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page" /> 
			<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
			<input type="hidden" value="" id="sortName" name="sortName" /> 
			<input type="hidden" value="" id="sortBy" name="sortBy" /> 
			<input type="hidden" value="" id="type" name="type" />
		</div>
	</div>
	<!-- /.main-content -->
	<script>
		var totalPage = $
		{
			model1.totalPage
		};
		var currentPage = $
		{
			model1.page
		};
		var limit = 5;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('create_date');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>
