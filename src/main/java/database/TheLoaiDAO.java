package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectdb.connectDB;
import model.TacGia;
import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{

	@Override
	public ArrayList<TheLoai> selectALL() {
		ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from theLoai";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				
				TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
				ketQua.add(tl);
			}
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai ketQua = null;
		try {
			Connection con = connectDB.getConnection();
			String sql = "select * from theLoai where maTheLoai = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaTheLoai());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				
				ketQua = new TheLoai(maTheLoai, tenTheLoai);
				break;
			}
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(TheLoai t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "insert into theLoai (maTheLoai, tenTheLoai)" + "values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaTheLoai());
			stmt.setString(2, t.getTenTheLoai());
			
			ketQua = stmt.executeUpdate();
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for (TheLoai theLoai : arr) {
			dem += this.insert(theLoai);
		}
		return dem;
	}

	@Override
	public int delete(TheLoai t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "delete from theLoai " + " where maTheLoai = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getMaTheLoai());
			ketQua = stmt.executeUpdate();
			connectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for (TheLoai theLoai : arr) {
			dem += this.delete(theLoai);
		}
		return dem;
	}

	@Override
	public int update(TheLoai t) {
		int ketQua = 0;
		try {
			Connection con = connectDB.getConnection();
			String sql = "update theLoai " + "set tenTheLoai = ? " + "where maTheLoai = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, t.getTenTheLoai());
			stmt.setString(2, t.getMaTheLoai());
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
		TheLoaiDAO tld = new TheLoaiDAO();
//		ArrayList<TheLoai> kq = tld.selectALL();
//		for (TheLoai theLoai : kq) {
//			System.out.println(theLoai.toString());
//		}
		
		//selectById
//		TheLoai tl = tld.selectById(new TheLoai("CT", ""));
//		System.out.println(tl.getTenTheLoai());
		
		//insert
//		TheLoai tl_new = new TheLoai("HH", "Hoạt hình");
//		tld.insert(tl_new);
		
//		delete
//		TheLoai tl_new = new TheLoai("KK", "kkk");
//		tld.delete(tl_new);
		
		//update
//		TheLoai tl = tld.selectById(new TheLoai("CT", ""));
//		System.out.println(tl.getTenTheLoai());
//		tl.setTenTheLoai("Chính trị");
//		tld.update(tl);
//		tl = tld.selectById(new TheLoai("CT", ""));
//		System.out.println(tl.getTenTheLoai()	);
	}
	
}
