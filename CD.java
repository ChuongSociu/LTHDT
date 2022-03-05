package Tuan3;

import java.util.InputMismatchException;

public class CD implements Comparable<CD> {
	private int maCD, soBH;
	private String tuaCD;
	private double giaThanh;

	// constructor
	public CD(int maCD, int soBH, String tuaCD, double giaThanh) {
		super();
		this.maCD = maCD;
		this.soBH = soBH;
		this.tuaCD = tuaCD;
		this.giaThanh = giaThanh;
	}

	public CD() {
		super();
	}

	// ----------begin------------
	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		if (maCD > 0)
			this.maCD = maCD;
		else {
			this.maCD = 999999;
		}
	}

	public int getSoBH() {
		return soBH;
	}

	public void setSoBH(int soBH) {
		if (soBH > 0)
			this.soBH = soBH;
		else {
			throw new InputMismatchException("Số bài hát không được bé hơn 0");
		}
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if (!tuaCD.equals(""))
			this.tuaCD = tuaCD;
		else {
			this.tuaCD = "chưa xác định";
		}
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		if (giaThanh > 0)
			this.giaThanh = giaThanh;
		else {
			throw new InputMismatchException("Giá thành phải lớn hơn không");
		}
	}
	//---------sap xep theo gia ------------------------------------------------
	@Override
	public int compareTo(CD o) {
            return (int) (this.giaThanh - o.getGiaThanh());
	}
	// ----------end------------
	@Override
	public String toString() {
		return "\n Mã CD: " + maCD + 
				"\n Số bài hát: " + soBH + 
				"\n Tựa CD: " + tuaCD + 
				"\n Giá Thành: " + giaThanh;
	}

}
