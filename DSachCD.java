package Tuan3;


public class DSachCD  {
	private CD ds[];
	public int soluongHT = 0;
	public int soluongHTofDG = 0;

	// khởi tạo mảng
	public DSachCD(int soluong) {
		ds = new CD[soluong];
	}

	// tăng kích thước của mảng nếu đầy
	public void TangKichThuoc() {
		CD temp[] = new CD[ds.length * 2];
		for (int i = 0; i < ds.length; i++) {
			temp[i] = ds[i];
		}
		ds = temp;
	}

	// thêm 1 tài khoản
	public void them(CD cd) {
		if (soluongHT == ds.length)
			TangKichThuoc();

		if (timKiem(cd.getMaCD()) != -1) {
		} else {
			ds[soluongHT] = cd;
			soluongHT++;
		}
	}

	public int timKiem(int maCD) {
		for (int i = 0; i < soluongHT; i++) {
			if (maCD == ds[i].getMaCD())
				return i;
		}
		return -1;
	}

	// hàm xóa
	public void xoa(CD acc) {
		int vt = timKiem(acc.getMaCD());
		for (int i = vt; i < soluongHT - 1; i++) {
			ds[i] = ds[i + 1];
		}
		soluongHT--;
	}

	// hàm sắp xếp
	public void sua(CD sua) {
		int vt = timKiem(sua.getMaCD());
		ds[vt] = sua;
	}

	// hàm trả về tổng giá thành
	public double getMonney() {
		double ans = 0;
		for (int i = 0; i < soluongHT; i++) {
			ans += ds[i].getGiaThanh();
		}
		return ans;
	}

	// hoán vị
	public void swap(CD list[], int i, int j, CD temp) {
		temp = ds[i];
		ds[i] = ds[j];
		ds[j] = temp;
	}

	// hàm sắp xếp tăng dần theo giá thành
	public void sortTheoGiaThanh() {
		CD temp = null;
		for (int i = 0; i < soluongHT - 1; i++) {
			for (int j = i + 1; j < soluongHT; j++)
				if (ds[i].getGiaThanh() > ds[j].getGiaThanh()) {
					swap(ds, i, j, temp);
				}
		}
	}

	// hàm sắp xếp theo tựCD
	public void sortTheoTuaCD() {
		CD temp = null;
		for (int i = 0; i < soluongHT - 1; i++) {
			for (int j = i + 1; j < soluongHT; j++) {
				if (ds[i].getTuaCD().compareTo(ds[j].getTuaCD()) > 0) {
					swap(ds, i, j, temp);
				}
			}
		}
	}

	// trả về danh sách
	public CD [] getDSBeHonN(double soTien) {
		soluongHTofDG = 0;
		CD temp[] = new CD[soluongHT];
		//int dem = 0;
		for (int i = 0; i < soluongHT; i++) {
			if (ds[i].getGiaThanh() <= soTien)
			{
				temp[soluongHTofDG] = ds[i]; 
				soluongHTofDG++;
			}
		}
		return temp;
	}

	// hàm trả về danh sách
	public CD[] getDsAC() {
		return ds;
	}

	

}
