<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookStore</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.min.js" integrity="sha384-RuyvpeZCxMJCqVUGFI0Do1mQrods/hhxYlcVfGPOfQtPJh0JCw12tUAZ/Mv10S7D" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<%
		// Lấy context path để sử dụng cho các đường dẫn tuyệt đối
		String contextPath = request.getContextPath();
	%>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="<%= contextPath %>/img/logo/Bootstrap_logo.svg" alt="Bootstrap" width="30" height="24">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Combo giảm giá</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Thể loại
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Quần Jean</a></li>
            <li><a class="dropdown-item" href="#">Áo thun</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Hết hàng</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Nội dung tìm kiếm" aria-label="Search"/>
        <button class="btn btn-outline-success" type="submit" style="margin-right: 20px;">Tìm</button>
        <%
        	Object obj = session.getAttribute("khachHang");
        	KhachHang khachHang = null;
        	if (obj != null) 
        		khachHang = (KhachHang)obj;
        	
        	if (khachHang == null) {
        		
        %>
        <a class="btn btn-primary" style="white-space: nowrap;" href="<%= contextPath %>/KhachHang/dangnhap.jsp">Đăng nhập</a>
      	<%} else {%>
      		<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor">
    <li class="nav-item dropdown dropstart">
        <a class="nav-link dropdown-toggle fw-bold" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="margin-right: ;">
            Tài khoản
        </a>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
            <li><a class="dropdown-item" href="#">Thông báo</a></li>
            <li><a class="dropdown-item" href="<%= contextPath %>/KhachHang/thaydoithongtin.jsp">Thay đổi thông tin</a></li>
            <li><a class="dropdown-item" href="<%= contextPath %>/KhachHang/doimatkhau.jsp">Đổi mật khẩu</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item text-danger" href="<%= contextPath %>/khach-hang?hanhDong=dang-xuat">Thoát tài khoản</a></li>
        </ul>
    </li>
</ul>	
      	<%} %>
      </form>
    </div>
  </div>
</nav>
<!-- End navbar -->
<!-- Page content -->
<div class="container">
<!-- Menu left -->
	<div class="row">
		<div class="col-lg-3">
			<div class="list-group">
			  <a href="#" class="list-group-item list-group-item-action">
			    Thời trang nam 
			  </a>
			  <a href="#" class="list-group-item list-group-item-action">Thời trang nữ</a>
			  <a href="#" class="list-group-item list-group-item-action">Dành cho bé</a>
			</div>
		</div>
<!-- End Menu left -->
<!-- Slider and product -->
		<div class="col-lg-9">
			<!-- Slider -->
			<div id="carouselExampleIndicators" class="carousel slide">
				  <div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
				  </div>
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="<%= contextPath %>/img/slider/slide1.webp" class="d-block w-100" alt="slide1" style="width: 100%; height: 200px">
				    </div>
				    <div class="carousel-item">
				      <img src="<%= contextPath %>/img/slider/slide2.webp" class="d-block w-100" alt="slide2" style="width: 100%; height: 200px">
				    </div>
				    <div class="carousel-item">
				      <img src="<%= contextPath %>/img/slider/slide3.webp" class="d-block w-100" alt="slide3" style="width: 100%; height: 200px">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
			</div>
			<!-- End Slider -->
			<!-- Products -->
				<div class="row">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card" style="width: 18rem;">
						  <img src="<%= contextPath %>/img/product/product1.webp" class="card-img-top" alt="...">
						  	<div class="card-body">
						    	<h5 class="card-title">Áo sơ mi sọc caro</h5>
						    	<p class="card-text">Chất liệu cotton tự nhiên, có khả năng thấm hút mồ hôi và thoáng khí tốt.</p>
						    	<a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
						  	</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card" style="width: 18rem;">
						  <img src="<%= contextPath %>/img/product/product2.webp" class="card-img-top" alt="..." style="height: 382px">
						  	<div class="card-body">
						    	<h5 class="card-title">Áo sơ mi xanh</h5>
						    	<p class="card-text">Chất liệu cotton tự nhiên, có khả năng thấm hút mồ hôi và thoáng khí tốt.</p>
						    	<a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
						  	</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card" style="width: 18rem;">
						  <img src="<%= contextPath %>/img/product/product3.webp" class="card-img-top" alt="...">
						  	<div class="card-body">
						    	<h5 class="card-title">Áo sơ mi trắng</h5>
						    	<p class="card-text">Chất liệu cotton tự nhiên, có khả năng thấm hút mồ hôi và thoáng khí tốt.</p>
						    	<a href="#" class="btn btn-primary">Thêm vào giỏ hàng</a>
						  	</div>
						</div>
					</div>
				</div>
			<!-- End Products -->
		</div>
<!-- End Slider and product -->
	</div>
</div>
<!-- End Page Content -->
<!-- Footer -->
  <footer style="background-color: #ffede7;">
    <div class="container p-4">
      <div class="row">
        <div class="col-lg-3 col-md-6 mb-4">
          <h5 class="mb-3" style="letter-spacing: 2px; color: #7f4722;">shopping online</h5>
          <ul class="list-unstyled mb-0">
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">frequently asked questions</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">delivery</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">pricing</a>
            </li>
            <li>
              <a href="#!" style="color: #4f4f4f;">where we deliver?</a>
            </li>
          </ul>
        </div>
        <div class="col-lg-3 col-md-6 mb-4">
          <h5 class="mb-3" style="letter-spacing: 2px; color: #7f4722;">git cards</h5>
          <ul class="list-unstyled mb-0">
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">frequently asked questions</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">delivery and payment</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">activate the card</a>
            </li>
            <li>
              <a href="#!" style="color: #4f4f4f;">rules</a>
            </li>
          </ul>
        </div>
        <div class="col-lg-3 col-md-6 mb-4">
          <h5 class="mb-3" style="letter-spacing: 2px; color: #7f4722;">company</h5>
          <ul class="list-unstyled mb-0">
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">buy a gift card</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">history</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">return</a>
            </li>
            <li>
              <a href="#!" style="color: #4f4f4f;">contact</a>
            </li>
          </ul>
        </div>
        <div class="col-lg-3 col-md-6 mb-4">
          <h5 class="mb-3" style="letter-spacing: 2px; color: #7f4722;">diamond club</h5>
          <ul class="list-unstyled mb-0">
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">registration</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">application</a>
            </li>
            <li class="mb-1">
              <a href="#!" style="color: #4f4f4f;">about program</a>
            </li>
            <li>
              <a href="#!" style="color: #4f4f4f;">rules</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
      © 2020 Copyright:
      <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
  </footer>
<!-- End Footer -->
</body>
</html>
