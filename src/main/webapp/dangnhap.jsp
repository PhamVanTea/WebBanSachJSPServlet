<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">	
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js"
	integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" crossorigin="anonymous"></script>
	<style>
		.error {
			color: red;
		}
	</style>
<%
	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<link href="<%=url %>/css/dangnhap.css" rel="stylesheet">

</head>
<body>
	<main class="form-signin w-100 m-auto">
		<form class="text-center" action="dang-nhap" method="POST">
			<img class="mb-4" src="img/logo/Bootstrap_logo.webp"
				alt="logo" width="72">
			<%
				String baoLoi = request.getAttribute("baoLoi")+"";
				if (baoLoi.equals("null")) {
					baoLoi = "";
				}
			%>
			<h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
			<div class="text-center"><span class="error"><%=baoLoi %></span></div>
			<div class="form-floating">
				<input type="text" class="form-control" id="tenDangNhap"
					placeholder="Tên đăng nhập" name="tenDangNhap"> <label for="tenDangNhap">Tên đăng nhập</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="matKhau"
					placeholder="Mật khẩu" name="matKhau"> <label for="matKhau">Mật khẩu</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Ghi nhớ tài khoản này
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng nhập</button>
			<a href="dangky.jsp">Đăng ký tài khoản mới</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2025</p>
		</form>
	</main>
</body>
</html>