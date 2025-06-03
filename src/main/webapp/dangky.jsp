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
<script src="https://code.jquery.com/jquery-3.6.4.min.js" crossorigin="anonymous"></script>
	<style>
		.error {
			color: red;
		}
	</style>
</head>
<body>
	<%
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi =  (baoLoi.equals("null"))?"":baoLoi;
		
		String tenDangNhap = request.getAttribute("tenDangNhap")+"";
		tenDangNhap =  (tenDangNhap.equals("null"))?"":tenDangNhap;
		
		String hoVaTen = request.getAttribute("hoVaTen")+"";
		hoVaTen =  (hoVaTen.equals("null"))?"":hoVaTen;
		
		String gioiTinh = request.getAttribute("gioiTinh")+"";
		gioiTinh =  (gioiTinh.equals("null"))?"":gioiTinh;
		
		String ngaySinh = request.getAttribute("ngaySinh")+"";
		ngaySinh =  (ngaySinh.equals("null"))?"":ngaySinh;
		
		String diaChiKhachHang = request.getAttribute("diaChiKhachHang")+"";
		diaChiKhachHang =  (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;
		
		String diaChiMuaHang = request.getAttribute("diaChiMuaHang")+"";
		diaChiMuaHang =  (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;
		
		String diaChiNhanHang = request.getAttribute("diaChiNhanHang")+"";
		diaChiNhanHang =  (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;
		
		String dienThoai = request.getAttribute("dienThoai")+"";
		dienThoai =  (dienThoai.equals("null"))?"":dienThoai;
		
		String email = request.getAttribute("email")+"";
		email =  (email.equals("null"))?"":email;
		
		String dongYNhanMail = request.getAttribute("dongYNhanMail")+"";
		dongYNhanMail =  (dongYNhanMail.equals("null"))?"":dongYNhanMail;
	%>
	<div class="container">
		<h1 class="text-center">ĐĂNG KÝ TÀI KHOẢN</h1>
		<div class="error" id="baoLoi">
			<%=baoLoi %>
		</div>
			<form action="dang-ky" method="post">
				<div class="row">
					<div class="col-md-6">
					<h3>Tài khoản</h3>
				<div class="mb-3">
					<label for="tenDangNhap" class="form-label">Tên đăng nhập</label> <span class="error">*</span>
					<input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" required="required" value="<%=tenDangNhap%>">
				</div>
				<div class="mb-3">
					<label for="matKhau" class="form-label">Mật khẩu</label> <span class="error">*</span>
					<input type="password" class="form-control" id="matKhau" name="matKhau" required="required" onkeyup="kiemTraMatKhau()">
				</div>
				<div class="mb-3">
					<label for="matKhauNhapLai" class="form-label">Nhập lại mật khẩu</label> <span class="error">*</span>
					<input type="password" class="form-control" id="matKhauNhapLai" name="matKhauNhapLai" required="required" onkeyup="kiemTraMatKhau()"> <span id="msg" class="error"></span>
				</div>
				<hr/>
				<h3>Thông tin khách hàng</h3>
				<div class="mb-3">
					<label for="hoVaTen" class="form-label">Họ và tên</label> 
					<input type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen%>"> 
				</div>
				<div class="mb-3">
					<label for="gioiTinh" class="form-label">Giới tính</label> 
					<select class="form-control" id="gioiTinh" name="gioiTinh" value="<%=gioiTinh%>">
						<option></option>
						<option value="Nam" <%=(gioiTinh == "Nam")?"selected = 'selected'":"" %>>Nam</option>
						<option value="Nữ" <%=(gioiTinh == "Nữ")?"selected = 'selected'":"" %>>Nữ</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="ngaySinh" class="form-label">Ngày sinh</label> 
					<input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>">
				</div>
				</div>
		<div class="col-md-6">
			<h3>Địa chỉ</h3>
				<div class="mb-3">
					<label for="diaChiKhachHang" class="form-label">Địa chỉ khách hàng</label> 
					<input type="text" class="form-control" id="diaChiKhachHang" name="diaChiKhachHang" value="<%=diaChiKhachHang%>">
				</div>
				<div class="mb-3">
					<label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label> 
					<input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang" value="<%=diaChiMuaHang%>">
				</div>
				<div class="mb-3">
					<label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label> 
					<input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang" value="<%=diaChiNhanHang%>">
				</div>
				<div class="mb-3">
					<label for="dienThoai" class="form-label">Điện thoại</label> 
					<input type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai%>">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email</label> 
					<input type="email" class="form-control" id="email" name="email" value="<%=email%>">
				</div>
				<hr/>
				<div class="mb-3">
					<label for="dongYDieuKhoan" class="form-label">Đồng ý với <a href="#">điều khoản của chúng tôi</a></label> <span class="error">*</span>
					<input type="checkbox" class="form-check-input" id="dongYDieuKhoan" name="dongYDieuKhoan" required="required" onchange="xuLyChonDongY()">
				</div>
				<div class="mb-3">
					<label for="dongYNhanMail" class="form-label">Đồng ý nhận email</label>
					<input type="checkbox" class="form-check-input" id="dongYNhanMail" name="dongYNhanMail" >
				</div>
				<input class="btn btn-primary form-control" type="submit" value="Đăng ký" name="submit" id="submit" style="visibility: hidden;"/>
				</div>
		</div>
	</form>
	</div>
</body>
<script>
	function kiemTraMatKhau() {
		const matKhau = $('#matKhau').val();
		const matKhauNhapLai = $('#matKhauNhapLai').val();
		if (matKhau != matKhauNhapLai) {
			$('#msg').html("Mật khẩu không khớp");
			return false;
		} else {
			$('#msg').html("");
			return true;
		}
	}
	
	function xuLyChonDongY() {
		const dongYDieuKhoan = $('#dongYDieuKhoan').is(':checked'); // Kiểm tra trạng thái checkbox
		if (dongYDieuKhoan) {
			$('#submit').css('visibility', 'visible'); 
		} else {
			$('#submit').css('visibility', 'hidden'); // Ẩn nút submit
		}
	}
</script>
</html>
