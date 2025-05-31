package database;

import java.util.ArrayList;

import model.DonHang;
import model.ChiTietDonHang;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {
	private ArrayList<ChiTietDonHang> data = new ArrayList<>();

	@Override
	public ArrayList<ChiTietDonHang> selectALL() {
		// TODO Auto-generated method stub
		return this.data;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		for (ChiTietDonHang ChiTietDonHang : data) {
			if (data.equals(t)) {
				return ChiTietDonHang;
			}
		}
		return null;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		// TODO Auto-generated method stub
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem += this.insert(ChiTietDonHang);
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		// TODO Auto-generated method stub
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem += this.delete(ChiTietDonHang);
		}
		return dem;
	}
	
	public int deleteAll(DonHang dh) {
		// TODO Auto-generated method stub
		int dem = 0;
		for (ChiTietDonHang chiTietDonHang : data) {
			if (chiTietDonHang.getDonHang().equals(dh)) {
				this.delete(chiTietDonHang);
			}
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHang t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}



