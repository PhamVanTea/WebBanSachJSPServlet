package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectdb.connectDB;
import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang> {

    @Override
    public ArrayList<DonHang> selectALL() {
        ArrayList<DonHang> ketQua = new ArrayList<>();
        try {
            Connection con = connectDB.getConnection();
            String sql = "SELECT * FROM donhang";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKhachHang = rs.getString("maKhachHang");
                String diaChiMuaHang = rs.getString("diaChiMuaHang");
                String diaChiNhanHang = rs.getString("diaChiNhanHang");
                String trangThai = rs.getString("trangThai");
                String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
                String trangThaiThanhToan = rs.getString("trangThaiThanhToan");
                double soTienDaThanhToan = rs.getDouble("soTienDaThanhToan");
                double soTienConThieu = rs.getDouble("soTienConThieu");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                Date ngayGiaoHang = rs.getDate("ngayGiaoHang");

                KhachHang kh = (new KhachHangDAO().selectById(new KhachHang(maKhachHang, null, null, null, null, null, null, null, null, null, null, false)));
                DonHang dh = new DonHang(maDonHang, kh, diaChiMuaHang, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
                ketQua.add(dh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public DonHang selectById(DonHang t) {
        DonHang ketQua = null;
        try {
            Connection con = connectDB.getConnection();
            String sql = "SELECT * FROM donhang WHERE maDonHang = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getMaDonHang());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKhachHang = rs.getString("maKhachHang");
                String diaChiMuaHang = rs.getString("diaChiMuaHang");
                String diaChiNhanHang = rs.getString("diaChiNhanHang");
                String trangThai = rs.getString("trangThai");
                String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
                String trangThaiThanhToan = rs.getString("trangThaiThanhToan");
                double soTienDaThanhToan = rs.getDouble("soTienDaThanhToan");
                double soTienConThieu = rs.getDouble("soTienConThieu");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                Date ngayGiaoHang = rs.getDate("ngayGiaoHang");

                KhachHang kh = (new KhachHangDAO().selectById(new KhachHang(maKhachHang, null, null, null, null, null, null, null, null, null, null, false)));
                ketQua = new DonHang(maDonHang, kh, diaChiMuaHang, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(DonHang t) {
        int ketQua = 0;
        try {
            Connection con = connectDB.getConnection();
            String sql = "INSERT INTO donhang (maDonHang, maKhachHang, diaChiMuaHang, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getMaDonHang());
            stmt.setString(2, t.getKhachHang().getMaKhachHang());
            stmt.setString(3, t.getDiaChiMuaHang());
            stmt.setString(4, t.getDiaChiNhanHang());
            stmt.setString(5, t.getTrangThai());
            stmt.setString(6, t.getHinhThucThanhToan());
            stmt.setString(7, t.getTrangThaiThanhToan());
            stmt.setDouble(8, t.getSoTienDaThanhToan());
            stmt.setDouble(9, t.getSoTienConThieu());
            stmt.setDate(10, t.getNgayDatHang());
            stmt.setDate(11, t.getNgayGiaoHang());
            ketQua = stmt.executeUpdate();
            connectDB.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<DonHang> arr) {
        int dem = 0;
        for (DonHang dh : arr) {
            dem += this.insert(dh);
        }
        return dem;
    }

    @Override
    public int delete(DonHang t) {
        int ketQua = 0;
        try {
            Connection con = connectDB.getConnection();
            String sql = "DELETE FROM donhang WHERE maDonHang = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getMaDonHang());
            ketQua = stmt.executeUpdate();
            connectDB.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<DonHang> arr) {
        int dem = 0;
        for (DonHang dh : arr) {
            dem += this.delete(dh);
        }
        return dem;
    }

    @Override
    public int update(DonHang t) {
        int ketQua = 0;
        try {
            Connection con = connectDB.getConnection();
            String sql = "UPDATE donhang SET maKhachHang=?, diaChiMuaHang=?, diaChiNhanHang=?, trangThai=?, hinhThucThanhToan=?, trangThaiThanhToan=?, soTienDaThanhToan=?, soTienConThieu=?, ngayDatHang=?, ngayGiaoHang=? WHERE maDonHang=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getKhachHang().getMaKhachHang());
            stmt.setString(2, t.getDiaChiMuaHang());
            stmt.setString(3, t.getDiaChiNhanHang());
            stmt.setString(4, t.getTrangThai());
            stmt.setString(5, t.getHinhThucThanhToan());
            stmt.setString(6, t.getTrangThaiThanhToan());
            stmt.setDouble(7, t.getSoTienDaThanhToan());
            stmt.setDouble(8, t.getSoTienConThieu());
            stmt.setDate(9, t.getNgayDatHang());
            stmt.setDate(10, t.getNgayGiaoHang());
            stmt.setString(11, t.getMaDonHang());
            ketQua = stmt.executeUpdate();
            connectDB.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static void main(String[] args) {
        DonHangDAO dhd = new DonHangDAO();

        // selectALL
//        ArrayList<DonHang> dh = dhd.selectALL();
//        for (DonHang donHang : dh) {
//            System.out.println(donHang.toString());
//        }

        // selectById
//        DonHang dh = dhd.selectById(new DonHang("123", null, null, null, null, null, null, 0, 0, null, null));
//        System.out.println(dh);

        // insert
//        KhachHang kh = new KhachHangDAO().selectById(new KhachHang("KH1", null, null, null, null, null, null, null, null, null, null, false));
//        DonHang dh = new DonHang("DH3", kh, "HCM", "HN", "Đang xử lý", "COD", "Chưa thanh toán", 0, 100000, new Date(System.currentTimeMillis()), null);
//        dhd.insert(dh);

        // delete
//        DonHang dh = dhd.selectById(new DonHang("DH3", null, null, null, null, null, null, 0, 0, null, null));
//        dhd.delete(dh);

        // update
//        DonHang dh = dhd.selectById(new DonHang("123", null, null, null, null, null, null, 0, 0, null, null));
//        if (dh != null) {
//            dh.setTrangThai("Hoàn thành");
//            dhd.update(dh);
//        }
    }
}
