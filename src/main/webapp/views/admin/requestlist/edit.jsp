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
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
			
				<div class="row">
					<div class="col-xs-12">
					<form action="admin-requestlist" method="post">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<c:if test="${model.status == 0 }">
											<input type="submit" class="dt-button buttons-html5 btn btn-success" 
												value="Duyệt thành viên" name="btnAccept" id="btnUpdate" />
											<input type="submit" class="dt-button buttons-html5 btn btn-danger" 
												value="Xóa" name="btnDelete" id="btnDelete"/>
										</c:if>
										<c:if test="${model.status == 1 }">
											<input type="submit" class="dt-button buttons-html5 btn btn-info" 
												value="Duyệt cựu thành viên" name="btnFinish" id="btnUpdate"/>
										</c:if>	
										<c:if test="${model.status == 2 }">
											<input type="submit" class="dt-button buttons-html5 btn btn-danger" 
												value="Xóa" name="btnDelete" id="btnDelete"/>
										</c:if>
											<input type="hidden" value="${model.requestID}" id="requestID" name="requestID" />
									</div>
								</div>
							</div>
						</form>

						<div class="row">
							<div class="col-xs-12">
								<%-- <c:if test="${not empty message}">
									<div class="alert alert-${alert}">${message}</div>
								</c:if> --%>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Mã
												sinh viên</strong></label>
										<div class="col-sm-9">
											<label class="control-label">${model.memberID}</label> 
											<!-- <input type="hidden" name="memberID" id="memberID"> -->
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
										<label class="col-sm-3 control-label no-padding-right"><strong>Mã
												CLB</strong></label>
										<div class="col-sm-9">
											<label class="control-label">${model.clubID} </label> 
											<!-- <input type="hidden" id="clubID" name="clubID" /> -->
										</div>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Tên
												CLB</strong></label>
										<div class="col-sm-9">
											<c:forEach var="clubs" items="${clubs}">
												<c:if test="${clubs.clubID.equals(model.clubID)}">
													<label class="control-label">${clubs.clubName}</label>
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
												<label class="control-label">Thành viên</label>
											</div>
										</c:if>
										<c:if test="${model.status == 2}">
											<div class="col-sm-9">
												<label class="control-label">Cựu thành viên</label>
											</div>
										</c:if>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Thời
												điểm đăng ký</strong></label>
										<div class="col-sm-9">
											<label class="control-label">${model.requestTime }</label>
										</div>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Thời
												điểm duyệt</strong></label>
										<div class="col-sm-9">
											<label class="control-label">${model.acceptTime }</label>
										</div>
									</div>
									<br />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"><strong>Thời
												điểm hoàn thành</strong></label>
										<div class="col-sm-9">
											<label class="control-label">${model.finishTime }</label>
										</div>
									</div>
							</div>
						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>