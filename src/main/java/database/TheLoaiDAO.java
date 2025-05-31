package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	private ArrayList<TheLoai> data = new ArrayList<>();

	@Override
	public ArrayList<TheLoai> selectALL() {
		// TODO Auto-generated method stub
		
		return this.data;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		// TODO Auto-generated method stub
		for (TheLoai theLoai : data) {
			if (data.equals(t)) {
				return theLoai;
			}
		}
		return null;
	}

	@Override
	public int insert(TheLoai t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		// TODO Auto-generated method stub
		int dem = 0;
		for (TheLoai theLoai : arr) {
			dem += this.insert(theLoai);
		}
		return dem;
	}

	@Override
	public int delete(TheLoai t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		// TODO Auto-generated method stub
		int dem = 0;
		 for (TheLoai theLoai : arr) {
			dem += this.delete(theLoai);
		}
		 return dem;
	}

	@Override
	public int update(TheLoai t) {
		// TODO Auto-generated method stub
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}
	
}
