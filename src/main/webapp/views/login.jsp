<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Đăng nhập</title>
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
                        <form action="<c:url value='/dang-nhap'/>" id="formLogin" method="post">
                            <h3 class="text-center text-info">Đăng nhập</h3>
							
							<div class="form-group">
                                <label for="email" class="text-info">Email:</label><br>
                                <input type="text" id="email" name="email" placeholder="Email"class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Mật khẩu:</label><br>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">
                            </div>
                            <div class="form-group">
                                <br>
                                <input type="submit" name="login" class="btn btn-info btn-md" value="Đăng nhập">
                                <br>
								
							</div>
                            <div id="register-link" class="text-right">
                                <a href="dangkyController" class="text-info">Đăng ký</a>
                            </div>
                            <input type="hidden" value="login" name="action"/>
                        </form>
					</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>