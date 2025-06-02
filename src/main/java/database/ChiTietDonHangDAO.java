package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectdb.connectDB;
import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

    @Override
    public ArrayList<ChiTietDonHang> selectALL() {
        ArrayList<ChiTietDonHang> ketQua = new ArrayList<>();
        try {
            Connection con = connectDB.getConnection();
            String sql = "SELECT * FROM chitietdonhang";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maChiTietDonHang = rs.getString("maChiTietDonHang");
                String maDonHang = rs.getString("maDonHang");
                String maSanPham = rs.getString("maSanPham");
                double soLuong = rs.getDouble("soLuong");
                double giaGoc = rs.getDouble("giaGoc");
                double giamGia = rs.getDouble("giamGia");
                double giaBan = rs.getDouble("giaBan");
                double thueVAT = rs.getDouble("thueVAT");
                double tongTien = rs.getDouble("tongTien");

                DonHang donHang = new DonHangDAO().selectById(new DonHang(maDonHang, null, null, null, null, null, null, 0, 0, null, null));
                SanPham sanPham = new SanPhamDAO().selectById(new SanPham(maSanPham, null, null, 0, 0, 0, tongTien, 0, null, maSanPham, maSanPham));
                ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, donHang, sanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
                ketQua.add(ctdh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietDonHang selectById(ChiTietDonHang t) {
        ChiTietDonHang ketQua = null;
        try {
            Connection con = connectDB.getConnection();
            String sql = "SELECT * FROM chitietdonhang WHERE maChiTietDonHang = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getMaChiTietDonHang());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maChiTietDonHang = rs.getString("maChiTietDonHang");
                String maDonHang = rs.getString("maDonHang");
                String maSanPham = rs.getString("maSanPham");
                double soLuong = rs.getDouble("soLuong");
                double giaGoc = rs.getDouble("giaGoc");
                double giamGia = rs.getDouble("giamGia");
                double giaBan = rs.getDouble("giaBan");
                double thueVAT = rs.getDouble("thueVAT");
                double tongTien = rs.getDouble("tongTien");

                DonHang donHang = new DonHangDAO().selectById(new DonHang(maDonHang, null, null, null, null, null, null, 0, 0, null, null));
                SanPham sanPham = new SanPhamDAO().selectById(new SanPham(maSanPham, null, null, 0, 0, 0, tongTien, 0, null, maSanPham, maSanPham));
                ketQua = new ChiTietDonHang(maChiTietDonHang, donHang, sanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            Connection con = connectDB.getConnection();
            String sql = "INSERT INTO chitietdonhang (maChiTietDonHang, maDonHang, maSanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getMaChiTietDonHang());
            stmt.setString(2, t.getDonHang().getMaDonHang());
            stmt.setString(3, t.getSanPham().getMaSanPham());
            stmt.setDouble(4, t.getSoLuong());
            stmt.setDouble(5, t.getGiaGoc());
            stmt.setDouble(6, t.getGiamGia());
            stmt.setDouble(7, t.getGiaBan());
            stmt.setDouble(8, t.getThueVAT());
            stmt.setDouble(9, t.getTongTien());
            ketQua = stmt.executeUpdate();
            connectDB.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;
        for (ChiTietDonHang ctdh : arr) {
            dem += this.insert(ctdh);
        }
        return dem;
    }

    @Override
    public int delete(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            Connection con = connectDB.getConnection();
            String sql = "DELETE FROM chitietdonhang WHERE maChiTietDonHang = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getMaChiTietDonHang());
            ketQua = stmt.executeUpdate();
            connectDB.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;
        for (ChiTietDonHang ctdh : arr) {
            dem += this.delete(ctdh);
        }
        return dem;
    }

    @Override
    public int update(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            Connection con = connectDB.getConnection();
            String sql = "UPDATE chitietdonhang SET maDonHang=?, maSanPham=?, soLuong=?, giaGoc=?, giamGia=?, giaBan=?, thueVAT=?, tongTien=? WHERE maChiTietDonHang=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getDonHang().getMaDonHang());
            stmt.setString(2, t.getSanPham().getMaSanPham());
            stmt.setDouble(3, t.getSoLuong());
            stmt.setDouble(4, t.getGiaGoc());
            stmt.setDouble(5, t.getGiamGia());
            stmt.setDouble(6, t.getGiaBan());
            stmt.setDouble(7, t.getThueVAT());
            stmt.setDouble(8, t.getTongTien());
            stmt.setString(9, t.getMaChiTietDonHang());
            ketQua = stmt.executeUpdate();
            connectDB.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static void main(String[] args) {
        ChiTietDonHangDAO ctdhd = new ChiTietDonHangDAO();

        // selectALL
//        ArrayList<ChiTietDonHang> ctdhList = ctdhd.selectALL();
//        for (ChiTietDonHang ctdh : ctdhList) {
//            System.out.println(ctdh);
//        }

        // selectById
//        ChiTietDonHang ctdh = ctdhd.selectById(new ChiTietDonHang("123", null, null, 0, 0, 0, 0, 0, 0));
//        System.out.println(ctdh);

         //insert
//        DonHang dh = new DonHangDAO().selectById(new DonHang("123", null, null, null, null, null, null, 0, 0, null, null));
//        SanPham sp = new SanPhamDAO().selectById(new SanPham("SP1", null, null, 0, 0, 0, 0, 0, null, null, null));
//        ChiTietDonHang ctdh = new ChiTietDonHang("CTDH2", dh, sp, 2, 100000, 5000, 95000, 10, 190000);
//        ctdhd.insert(ctdh);

        // delete
//        ChiTietDonHang ctdh = ctdhd.selectById(new ChiTietDonHang("CTDH2", null, null, 0, 0, 0, 0, 0, 0));
//        ctdhd.delete(ctdh);

        // update
//        ChiTietDonHang ctdh = ctdhd.selectById(new ChiTietDonHang("123", null, null, 0, 0, 0, 0, 0, 0));
//        if (ctdh != null) {
//            ctdh.setSoLuong(5);
//            ctdhd.update(ctdh);
//        }
    }
}
