package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectdb.connectDB;
import model.KhachHang;
import model.SanPham;

public class KhachHangDAO implements DAOInterface<KhachHang>{

	@Override
	public ArrayList<KhachHang> selectALL() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from khachHang";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				
				KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);
				ketQua.add(kh);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang ketQua = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from khachHang where maKhachHang = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaKhachHang());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				
				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public KhachHang selectByUserNameAndPassword(KhachHang t) {
		KhachHang ketQua = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from khachHang where tenDangNhap = ? and matKhau = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTenDangNhap());
			stmt.setString(2, t.getMatKhau());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkinhanbangtin");
				
				ketQua = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			 Connection con = connectDB.getConnection();
			 String sql = "insert into khachHang (makhachhang, tendangnhap, matkhau, hoten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkinhanbangtin) "
			 		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 	stmt.setString(1, t.getMaKhachHang());
			 	stmt.setString(2, t.getTenDangNhap());
			 	stmt.setString(3, t.getMatKhau());
			 	stmt.setString(4, t.getHoVaTen());
			 	stmt.setString(5, t.getGioiTinh());
			 	stmt.setString(6, t.getDiaChi());
			 	stmt.setString(7, t.getDiaChiNhanHang());
			 	stmt.setString(8, t.getDiaChiMuaHang());
			 	stmt.setDate(9, t.getNgaySinh());
			 	stmt.setString(10, t.getSoDienThoai());
			 	stmt.setString(11, t.getEmail());
			 	stmt.setBoolean(12, t.isDangKyNhanBangTin());
			 	ketQua = stmt.executeUpdate();
			 	connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}


	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang khachHang : arr) {
			dem += this.insert(khachHang);
		}
		return dem;
	}


	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "delete from khachHang where maKhachHang = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaKhachHang());
			ketQua = stmt.executeUpdate();
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}


	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang khachHang : arr) {
			dem += this.delete(khachHang);
		}
		return dem;
	}


	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "UPDATE khachhang " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hoten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
					+ ", email=?" + ", dangkinhanbangtin=?" + " WHERE makhachhang=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTenDangNhap());
			stmt.setString(2, t.getMatKhau());
			stmt.setString(3, t.getHoVaTen());
			stmt.setString(4, t.getGioiTinh());
			stmt.setString(5, t.getDiaChi());
			stmt.setString(6, t.getDiaChiNhanHang());
			stmt.setString(7, t.getDiaChiMuaHang());
			stmt.setDate(8, t.getNgaySinh());
			stmt.setString(9, t.getSoDienThoai());
			stmt.setString(10, t.getEmail());
			stmt.setBoolean(11, t.isDangKyNhanBangTin());
			stmt.setString(12, t.getMaKhachHang()); // Đặt ID ở cuối
		 	
		 	ketQua = stmt.executeUpdate();
		 	connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public boolean kiemTraTenDangNhap(String tenDangNhap) {
		boolean ketQua = false;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from khachHang where tenDangNhap = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ketQua =  true;
			}
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public boolean changePassword(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "UPDATE khachhang " + " SET " + " matkhau=?" + " WHERE makhachhang=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMatKhau());
			stmt.setString(2, t.getMaKhachHang()); // Đặt ID ở cuối
		 	
		 	ketQua = stmt.executeUpdate();
		 	connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua > 0;
	}
	
	//kiểm tra dữ liệu
	public static void main(String[] args) {
		//selectAll
		KhachHangDAO khd = new KhachHangDAO();
//		ArrayList<KhachHang> kh = khd.selectALL();
//		for (KhachHang khachHang : kh) {
//			System.out.println(khachHang.toString());
//		}
		
		//selectById
//		KhachHang kh = khd.selectById(new KhachHang("KH2", null, null, null, null, null, null, null, null, null, null, false));
//		System.out.println(kh);
		
		//insert
//		KhachHang khachHang_new = new KhachHang("KH6", "kkk", "123", "VanTra", "Nam", "Trà Vinh", null, null, null, null, null, false);
//		khd.insert(khachHang_new);
		
		//delete
//		KhachHang khachHang_new = new KhachHang("KH6", "kkk", "123", "VanTra", "Nam", "Trà Vinh", null, null, null, null, null, false);
//		khd.delete(khachHang_new);
		
		//update
//		KhachHang kh = khd.selectById(new KhachHang("KH2", null, null, null, null, null, null, null, null, null, null, false));
//		kh.setHoVaTen("kkk");
//		khd.update(kh);	
	}
}


