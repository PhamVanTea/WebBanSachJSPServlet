package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectdb.connectDB;
import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {
	@Override
	public ArrayList<TacGia> selectALL() {
		// TODO Auto-generated method stub
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from tacGia";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");

				TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				ketQua.add(tg);
			}
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia t) {
		// TODO Auto-generated method stub
		TacGia ketQua = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from tacGia where maTacGia = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");

				ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
			}
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	@Override
	public int insert(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "insert into tacGia (maTacGia, hoVaTen, ngaySinh, tieuSu) " + " values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaTacGia());
			stmt.setString(2, t.getHoVaTen());
			stmt.setDate(3, t.getNgaySinh());
			stmt.setString(4, t.getTieuSu());
			
			ketQua = stmt.executeUpdate();
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.insert(tacGia);
		}
		return dem;
	}

	@Override
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "delete from tacGia "+ " where maTacGia = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaTacGia());
			ketQua = stmt.executeUpdate();
			connectDB.closeConnection(con);
			System.out.println("ok");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.delete(tacGia);
		}
		return dem;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "update tacGia " + " set " + " hoVaTen = ? " + " ,ngaySinh = ? " + " ,tieuSu = ? " + " where maTacGia = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getHoVaTen());
			stmt.setDate(2, t.getNgaySinh());
			stmt.setString(3, t.getTieuSu());
			stmt.setString(4, t.getMaTacGia());
			ketQua = stmt.executeUpdate();
			connectDB.closeConnection(con);
			System.out.println("ok");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public static void main(String[] args) { //kiểm tra dữ liệu có kết nối vs sql chưa 
		TacGiaDAO tgd = new TacGiaDAO();
//		ArrayList<TacGia> kq = tgd.selectALL();
//		for (TacGia tacGia : kq) {
//			System.out.println(tacGia.toString());
//		}
//		
//		//selectById
//		TacGia tg = tgd.selectById(new TacGia("TG2","", null, ""));
//		System.out.println(tg);
//		
//		//insert
//		TacGia tg_new = new TacGia("TG10", "David", new Date(2005-1900, 11, 11), "");
//		tgd.insert(tg_new);
		
		//delete
//		TacGia tg_new = new TacGia("TG10", "David", new Date(2005-1900, 11, 11), "");
//		tgd.delete(tg_new);
		
		//update
//		TacGia tg = tgd.selectById(new TacGia("TG1","", null, ""));
//		System.out.println(tg);
//		tg.setTieuSu("đã thay đổi ts");
//		tgd.update(tg);
	}
}
