package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;
import util.MaHoa;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import database.KhachHangDAO;

/**
 * Servlet implementation class DangKy
 */
@WebServlet(name = "DangKy", urlPatterns = { "/dang-ky" })
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String matKhauNhapLai = request.getParameter("matKhauNhapLai");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String diaChiMuaHang = request.getParameter("diaChiMuaHang");
		String diaChiNhanHang = request.getParameter("diaChiNhanHang");
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		
		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("email", email);
		request.setAttribute("dongYNhanMail", dongYNhanMail);
		
		String url = "";
		String baoLoi = "";
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		
		if (khachHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
			baoLoi += "Tên đăng nhập đã tồn tại.<br/>";
		}
		
		if (!matKhau.equals(matKhauNhapLai)) {
			baoLoi += "Mật khẩu không khớp.<br/>";
		} else {
			matKhau = MaHoa.toSHA1(matKhau);
		}
		request.setAttribute("baoLoi", baoLoi);
		
		request.setAttribute("baoLoi", baoLoi);
		
		if (baoLoi.length() > 0) {
			url = "/dangky.jsp";
		} else {
			Random rd = new Random();
			String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
			
			KhachHang kh = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null);
			khachHangDAO.insert(kh);
			url = "/thanhcong.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
