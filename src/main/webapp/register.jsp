<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
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
</head>
<body>
	<div class="container">
	<h1 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>
		<form action="">
		<form action="">
		<h3>Thông tin khách hàng</h3>
		<div class="mb-3">
			<label for="hoVaTen" class="form-label">Họ và tên</label> 
			<input type="text" class="form-control" id="hoVaTen" name="hoVaTen">
		</div>
		<div class="mb-3">
			<label for="gioiTinh" class="form-label">Giới tính</label> 
			<select class="form-control" id="gioiTinh" name="gioiTinh">
				<option></option>
				<option value="Nam">Nam</option>
				<option value="Nữ">Nữ</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="ngaySinh" class="form-label">Ngày sinh</label> 
			<input type="date" class="form-control" id="ngaySinh" name="ngaySinh">
		</div>
		<hr/>
	</form>
		<div class="mb-3">
			<label for="hoVaTen" class="form-label">Họ và tên</label> 
			<input type="text" class="form-control" id="hoVaTen" name="hoVaTen">
		</div>
		<div class="mb-3">
			<label for="gioiTinh" class="form-label">Giới tính</label> 
			<select class="form-control" id="gioiTinh" name="gioiTinh">
				<option></option>
				<option value="Nam">Nam</option>
				<option value="Nữ">Nữ</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="ngaySinh" class="form-label">Ngày sinh</label> 
			<input type="date" class="form-control" id="ngaySinh" name="ngaySinh">
		</div>
		<hr/>
		<h3>Địa chỉ</h3>
	</form>
	</div>
</body>
</html>