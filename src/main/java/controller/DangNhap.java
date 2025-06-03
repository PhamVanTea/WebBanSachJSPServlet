package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang;

import java.io.IOException;

import com.mysql.cj.Session;

import database.KhachHangDAO;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/dang-nhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		
		KhachHang kh = new KhachHang();
		kh.setTenDangNhap(tenDangNhap);
		kh.setMatKhau(matKhau);
		
		KhachHangDAO khd = new KhachHangDAO();
		KhachHang khachHang = khd.selectByUserNameAndPassword(kh);
		String url = "";
		if (khachHang != null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			url = "/index.jsp";
		} else {
			request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng");
			url = "/dangnhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
