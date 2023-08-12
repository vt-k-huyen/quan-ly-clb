<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiURL" value="/api-admin-requestlist"/>
<c:url var ="RequestListURL" value="/admin-requestlist"/>
<html>
<head>
<title>Xử lý yêu cầu</title>
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
					<li class="active">Xử lý yêu cầu</li>
					<li class="active">Tham gia hoạt động</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
			
				<div class="row">
					<div class="col-xs-12">
					<form action="admin-memberevent" method="post">
						<!-- <div class="widget-box table-filter"> -->
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<c:if test="${model.status == 0 }">
											<input type="submit" class="dt-button buttons-html5 btn btn-success" 
												value="Duyệt thành viên" name="btnAccept" id="btnUpdate" />
											<input type="submit" class="dt-button buttons-html5 btn btn-danger" 
												value="Từ chối" name="btnReject" id="btnReject"/>
										</c:if>
										<%-- <c:if test="${model.status == 1 }">
											
										</c:if>	 --%>
										<c:if test="${model.status == 2 }">
											<input type="submit" class="dt-button buttons-html5 btn btn-danger" 
												value="Xóa" name="btnDelete" id="btnDelete"/>
										</c:if>
											<input type="hidden" value="${model.id}" id="id" name="id" />
									</div>
								</div>
							</div>
						</form>
						<!-- </div> -->

						<div class="row">
							<div class="col-xs-12">
								<%-- <c:if test="${not empty message}">
									<div class="alert alert-${alert}">${message}</div>
								</c:if> --%>
								<!-- <form id="formSubmit"> -->
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Mã
												sinh viên</strong></label>
										<div class="col-sm-9">
											<label class="control-label">${model.memberID}</label> 
										</div>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Họ
												tên</strong></label>
										<div class="col-sm-9">
											<c:forEach var="members" items="${members}">
												<c:if test="${members.memberID.equals(model.memberID)}">
													<label class="control-label">${members.firstName}
														${members.lastName }</label>
												</c:if>
											</c:forEach>
										</div>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Hoạt động</strong></label>
										<div class="col-sm-9">
											<c:forEach var="events" items="${events}">
												<c:if test="${events.eventID.equals(model.eventID)}">
													<label class="control-label">${events.eventName}</label>
												</c:if>
											</c:forEach>
										</div>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Trạng
												thái xử lý</strong></label>
										<c:if test="${model.status == 0}">
											<div class="col-sm-9">
												<label class="control-label">Chưa duyệt</label>
											</div>
										</c:if>
										<c:if test="${model.status == 1}">
											<div class="col-sm-9">
												<label class="control-label">Đã tham gia</label>
											</div>
										</c:if>
										<c:if test="${model.status == 2}">
											<div class="col-sm-9">
												<label class="control-label">Đã từ chối</label>
											</div>
										</c:if>
									</div>
									<br />
							</div>
						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
<!-- 	<script>
		$('#btnUpdate').click(function(e) {
			e.preventDefault(); 
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
			var id = $('#requestID').val();
			var idtype = typeof(id);
			if(id != ""){
				update(data);
			}
		});
	 	function update(data){
	 		$.ajax({
				url : '${apiURL}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data || null),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${RequestListURL}?type=list&page=1&maxPageItem=2&sortName=status&sortBy=asc";
				},
				error : function(error) {
					window.location.href = "${RequestListURL}?type=edit&requestID="+result.requestID+"&message=error_system";
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
					window.location.href = "${AnnouncementURL}?type=edit&announcementID="+result.announcementID+"&message=update_success";
				},
				error : function(error) {
					window.location.href = "${AnnouncementURL}?type=edit&announcementID="+result.announcementID+"&message=error_system";
				}
			});
		}
	</script>   -->
</body>
</html>