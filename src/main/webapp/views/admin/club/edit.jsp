<%@ page language="java" contentType="text/html; charset=UTF-8"
  	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiURL" value="/api-admin-club"/>
<c:url var ="ClubURL" value="/admin-club"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa thông tin câu lạc bộ</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Sửa thông tin câu lạc bộ</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if> 
						<!-- <form id="formSubmit"> -->
						<form id="formSubmit">
							<c:if test="${empty model.clubID }">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Mã câu lac bộ</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="clubID" name="clubID"
										value="${model.clubID}" />
									</div>
								</div>
							</c:if>
							<br /> <br />
							<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tên câu lạc bộ</label>
                                <div class="col-sm-9">                                 
                                    <input type="text" class="form-control" id="clubID" name="clubID"
										value="${model.clubName}" />
                                </div>
                            </div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô tả</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="description" name="description"
										value="${model.description}" />
								</div>
							</div>
							<br /> <br />
							<c:if test="${empty model.clubID }">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">Ngày thành lập</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="createDate"
											name="createDate" value="${model.createDate}" />
									</div>
								</div>
								<br/> <br/>
							</c:if>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Ngày giải thể</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="dissolutionDate" name="dissolutionDate"
										value="${model.dissolutionDate}" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.clubID }">
										<input type="button"
											class="btn btn-primary"
											value="Cập nhật" name="btnAddOrUpdateTB" id="btnAddOrUpdateTB" />
									<!-- 	<button type="submit" class="btn btn-primary" value="Cập nhật thông báo" id="btnAddOrUpdateTB">
									<i class="fa fa-save"></i> Cập nhật thông báo
								</button>	 -->
									</c:if>
									<c:if test="${empty model.clubID }">
										<input type="button"
											class="btn btn-primary"
											value="Thêm mới" name="btnAddOrUpdateTB" id="btnAddOrUpdateTB" />
									</c:if>
									
								</div>
							</div>
							<input type="hidden" value="${model.clubID}" id="clubID" name="clubID" />
						</form>	
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateTB').click(function(e) {
			e.preventDefault(); 
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
			var id = $('#clubID').val();
			var idtype = typeof(id);
			if(id === ""){
				addClub(data);
			}else{
				updateClub(data);
			}
		});
	 	function addClub(data){
	 		$.ajax({
				url : '${apiURL}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data || null),
				dataType : 'json',
				success : function(result) {
					console.log(result);
				},
				error : function(error) {
					console.log(error);
				}
			});
			} 
		function updateClub(data) {
			$.ajax({
				url : '${apiURL}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data || null),
				dataType : 'json',
				success : function(result) {
					console.log(result);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>