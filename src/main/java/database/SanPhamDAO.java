	package database;
	
	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	
	import connectdb.connectDB;
	import model.SanPham;
	import model.TacGia;
	import model.TheLoai;
	import model.SanPham;
	
	public class SanPhamDAO implements DAOInterface<SanPham> {
	
		@Override
		public ArrayList<SanPham> selectALL() {
			ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
			try {
				Connection con = connectDB.getConnection();
				String sql = "select * from sanPham";
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maSanPham = rs.getString("maSanPham");
					String tenSanPham = rs.getString("tenSanPham");
					String maTacGia = rs.getString("maTacGia");
					int namXuatBan = rs.getInt("namXuatBan");
					Double giaNhap = rs.getDouble("giaNhap");
					Double giaGoc = rs.getDouble("giaGoc");
					Double giaBan = rs.getDouble("giaBan");
					int soLuong = rs.getInt("soLuong");
					String maTheLoai = rs.getString("maTheLoai");
					String ngonNgu = rs.getString("ngonNgu");
					String moTa = rs.getString("moTa");
					
					TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));  
					TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));
					
					SanPham sp = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, soLuong, soLuong, namXuatBan, soLuong, theLoai, ngonNgu, moTa);
					ketQua.add(sp);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ketQua;
		}
	
		@Override
		public SanPham selectById(SanPham t) {
			SanPham ketQua = null;
			try {
				Connection con = connectDB.getConnection();
				String sql = "select * from sanPham where maSanPham = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, t.getMaSanPham());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maSanPham = rs.getString("maSanPham");
					String tenSanPham = rs.getString("tenSanPham");
					String maTacGia = rs.getString("maTacGia");
					int namXuatBan = rs.getInt("namXuatBan");
					Double giaNhap = rs.getDouble("giaNhap");
					Double giaBan = rs.getDouble("giaBan");
					Double giaGoc = rs.getDouble("giaGoc");
					int soLuong = rs.getInt("soLuong");
					String maTheLoai = rs.getString("maTheLoai");
					String ngonNgu = rs.getString("ngonNgu");
					String moTa = rs.getString("moTa");
					
					TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));  
					TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));
					
					ketQua = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, soLuong, soLuong, namXuatBan, soLuong, theLoai, ngonNgu, moTa);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ketQua;
		}
	
		@Override
		public int insert(SanPham t) {
			int ketQua = 0;
			try {
				Connection con = connectDB.getConnection();
				String sql = "insert into sanPham (maSanPham, tenSanPham, maTacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, maTheLoai, ngonNgu, moTa) " + " values (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, t.getMaSanPham());
				stmt.setString(2, t.getTenSanPham());
				stmt.setString(3, t.getTacGia().getMaTacGia());
				stmt.setInt(4, t.getNamXuatBan());
				stmt.setDouble(5, t.getGiaNhap());
				stmt.setDouble(6, t.getGiaGoc());
				stmt.setDouble(7, t.getGiaBan());
				stmt.setInt(8, t.getSoLuong());
				stmt.setString(9, t.getTheLoai().getMaTheLoai());
				stmt.setString(10, t.getNgonNgu());
				stmt.setString(11, t.getMoTa());
				
				ketQua = stmt.executeUpdate();
				connectDB.closeConnection(con);
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ketQua;
		}
	
		@Override
		public int insertAll(ArrayList<SanPham> arr) {
			int dem = 0;
			for (SanPham sanPham : arr) {
				dem += this.insert(sanPham);
			}
			return dem;
		}
	
		@Override
		public int delete(SanPham t) {
			int ketQua = 0;
			try {
				Connection con = connectDB.getConnection();
				String sql = "delete from sanPham where maSanPham = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, t.getMaSanPham());
				ketQua = stmt.executeUpdate();
				connectDB.closeConnection(con);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ketQua;
		}
	
		@Override
		public int deleteAll(ArrayList<SanPham> arr) {
			int dem = 0;
			for (SanPham sanPham : arr) {
				dem += this.delete(sanPham);
			}
			return dem;
		}
	
		@Override
		public int update(SanPham t) {
			int ketQua = 0;
			try {
				Connection con = connectDB.getConnection();
				String sql = "update sanPham " + " set " + "tenSanPham=?, maTacGia=?, namXuatBan=?, giaNhap=?, giaGoc=?, "
						+ "giaBan=?, soLuong=?, maTheLoai=?, ngonNgu=?, moTa=?" + " where maSanPham=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, t.getTenSanPham()); 
				stmt.setString(2, t.getTacGia().getMaTacGia()); 
				stmt.setInt(3, t.getNamXuatBan()); 
				stmt.setDouble(4, t.getGiaNhap()); 
				stmt.setDouble(5, t.getGiaGoc());
				stmt.setDouble(6, t.getGiaBan()); 
				stmt.setInt(7, t.getSoLuong()); 
				stmt.setString(8, t.getTheLoai().getMaTheLoai());
				stmt.setString(9, t.getNgonNgu()); 
				stmt.setString(10, t.getMoTa()); 
				stmt.setString(11, t.getMaSanPham()); // maSanPham (điều kiện WHERE)

				
				ketQua = stmt.executeUpdate();
				connectDB.closeConnection(con);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ketQua;
		}
		
		//kiểm tra dữ liệu
		public static void main(String[] args) {
	//		selectALL
			SanPhamDAO spd = new SanPhamDAO();
	//		ArrayList<SanPham> kq = spd.selectALL();
	//		for (SanPham sanPham : kq) {
	//			System.out.println(sanPham.toString());
	//		}
			
			//selectById
//			SanPham sp = spd.selectById(new SanPham("SP3", null, null, 0, 0, 0, 0, 0, null, null, null));
//			System.out.println(sp);
			
	//		insert
//			TacGia tacGia = new TacGia("TG1", "", null, "");
//			TheLoai theLoai = new TheLoai("CT", "");
//			SanPham sp_new = new SanPham("SP6", "Java Spring", tacGia, 2000, 150000, 160000, 200000, 100, theLoai, "Viet", "");
//			spd.insert(sp_new);
			
	//		delete
//			TacGia tacGia = new TacGia("TG1", "", null, "");
//			TheLoai theLoai = new TheLoai("CT", "");
//			SanPham sp_new = new SanPham("SP6", "Java Spring", tacGia, 2000, 150000, 160000, 200000, 100, theLoai, "Viet", "");
//			spd.delete(sp_new);
//			//update
//			SanPham sp = spd.selectById(new SanPham("SP5", null, null, 0, 0, 0, 0, 0, null, null, null));
//			System.out.println(sp);
//			sp.setTenSanPham("NodeJS");
//			spd.update(sp);

		}
		
	}
	
