package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang;
import util.MaHoa;

import java.io.IOException;

import database.KhachHangDAO;

/**
 * Servlet implementation class DoiMatKhau
 */
@WebServlet("/doi-mat-khau")
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");
		
		String matKhauHienTai_Sha1 = MaHoa.toSHA1(matKhauHienTai);
		
		String baoLoi = "";
		
		//kiểm tra mk cũ có giống hay k
		String url = "/doimatkhau.jsp";
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if (obj != null) 
			khachHang = (KhachHang)obj;
		
		if (khachHang == null) {
			baoLoi = "Bạn chưa đăng nhập vào hệ thống";
		} else {
			if (!matKhauHienTai_Sha1.equals(khachHang.getMatKhau())) {
				baoLoi = "Mật khẩu hiện tại không chính xác";
			} else {
				if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
					baoLoi = "Mật khẩu nhập lại không khớp!";
				} else {
					String matKhauMoi_Sha1 = MaHoa.toSHA1(matKhauMoi);
					khachHang.setMatKhau(matKhauMoi_Sha1);
					KhachHangDAO khd = new KhachHangDAO();
					if (khd.changePassword(khachHang)) {
						baoLoi = "Mật khẩu đã thay đổi thành công";
					} else {
						baoLoi = "Quá trình thay đổi mật khẩu không thành công";
					}
				}
			}
		}
		
		request.setAttribute("baoLoi", baoLoi);
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
