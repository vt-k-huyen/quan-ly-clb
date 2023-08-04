<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiURL" value="/api-admin-announcement"/>
<c:url var ="AnnouncementURL" value="/admin-announcement"/>
<html>
<head>
<title>Chỉnh sửa thông báo</title>
<meta http-equiv="Content-Security-Policy" content="default-src https://cdn.example.net; child-src 'none'; object-src 'none'">
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
					<li class="active">Chỉnh sửa thông báo</li>
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
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Câu
									lạc bộ</label>
								<div class="col-sm-9">
									<select class="form-control" id="clubID" name="clubID">
										<c:if test="${empty model.clubID }">
											<option>Chọn CLB</option>
											<c:forEach var="item" items="${clubs}">
												<option value="${item.clubID}">${item.clubName}</option>
											</c:forEach>
										</c:if>

										<c:if test="${not empty model.clubID }">
											<option>Chọn CLB</option>
											<c:forEach var="item" items="${clubs}">
												<c:if test="${item.clubID == model.clubID }">
													<option value="${model.clubID}" selected="selected">${item.clubName}</option>
												</c:if>
												<c:if test="${item.clubID != model.clubID }">
													<option value="${item.clubID}">${item.clubName}</option>
												</c:if>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                <div class="col-sm-9">                                 
                                    <textarea form="formSubmit" rows="" cols="" id="content" name="content" style="width: 820px;height: 175px">${model.content}</textarea>
                                </div>
                            </div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Ghi
									chú</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="note" name="note"
										value="${model.note}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.announcementID }">
										<input type="button"
											class="btn btn-primary"
											value="Cập nhật thông báo" name="btnAddOrUpdateTB" id="btnAddOrUpdateTB" />
									<!-- 	<button type="submit" class="btn btn-primary" value="Cập nhật thông báo" id="btnAddOrUpdateTB">
									<i class="fa fa-save"></i> Cập nhật thông báo
								</button>	 -->
									</c:if>
									<c:if test="${empty model.announcementID }">
										<input type="button"
											class="btn btn-primary"
											value="Thêm thông báo" name="btnAddOrUpdateTB" id="btnAddOrUpdateTB" />
									</c:if>
									
								</div>
							</div>
							<input type="hidden" value="${model.announcementID}" id="announcementID" name="announcementID" />
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
			var id = $('#announcementID').val();
			var idtype = typeof(id);
			if(id == ""){
				addAnnouncement(data);
				
			}else{
				updateAnnouncement(data);
			}
		});
	 	function addAnnouncement(data){
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
		function updateAnnouncement(data) {
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