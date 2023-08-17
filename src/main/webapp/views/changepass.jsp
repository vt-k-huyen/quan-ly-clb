<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Đổi mật khẩu</title>
</head>
<body>
	<div id="login">
		
		<c:if test="${not empty message}">
					<div class="alert alert-${alert}">${message}</div>
		</c:if>
		<!--        <h3 class="text-center text-white pt-5">Login form</h3> -->
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form action="<c:url value='/doi-matkhau'/>" id="formLogin" method="post">
                            <h3 class="text-center text-info">Đổi mật khẩu</h3>
							
							<div class="form-group">
                                <label for="oldpass" class="text-info">Mật khẩu cũ:</label><br>
                                <input type="password" id="oldpass" name="oldpass" placeholder="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="newpass" class="text-info">Mật khẩu mới:</label><br>
                                <input type="password" class="form-control" id="newpass" name="newpass" placeholder="">
                            </div>
                            <div class="form-group">
                                <br>
                                <input type="submit" name="changepass" class="btn btn-info btn-md" value="Xác nhận">
                                <br>
								
							</div>
                            <div id="register-link" class="text-right">
                                <a href='<c:url value='/trang-chu'/>' class="text-info">Quay lại</a>
                            </div>
                            <input type="hidden" value="changepass" name="action"/>
                        </form>
					</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>