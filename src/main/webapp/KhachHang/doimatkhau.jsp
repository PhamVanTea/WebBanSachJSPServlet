<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj != null) 
			khachHang = (KhachHang)obj;
		
		if (khachHang == null) {
			
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống!</h1>
	<%
		} else {
			String baoLoi = request.getAttribute("baoLoi")+"";
			if (baoLoi.equals("null")) {
				baoLoi = "";
			}
	%>
	<div class="container">
	<h1>ĐỔI MẬT KHẨU</h1>
		<form action="../khach-hang" method="post">
		<input type="hidden" name="hanhDong" value="doi-mat-khau"/>
		  <div class="mb-3">
		    <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại</label>
		    <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
		  </div>
		  <div class="mb-3">
		    <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
		    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
		  </div>
		   <div class="mb-3">
		    <label for="matKhauMoiNhapLai" class="form-label">Nhập lại mật khẩu mới</label>
		    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai" onkeyup="kiemTraMatKhau()"> <span id="msg" class="text-danger"></span>
		  </div>
		  <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
		</form>
		<span class="text-danger">
		<%=baoLoi%>
	</span>
	</div>
<%} %>
</body>
<script>
	function kiemTraMatKhau() {
		const matKhauMoi = $('#matKhauMoi').val();
		const matKhauMoiNhapLai = $('#matKhauMoiNhapLai').val();
		if (matKhauMoi != matKhauMoiNhapLai) {
			$('#msg').html("Mật khẩu nhập lại không khớp");
		} else {
			$('#msg').html("");
		}
	}
</script>
</html>