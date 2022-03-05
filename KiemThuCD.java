package Tuan3;

import java.util.Arrays;
import java.util.Scanner;


public class KiemThuCD {
	static void Menu() {
		System.out.println("\t****************************************");
		System.out.println("\t**       Chương trình quản lí CD      **");
		System.out.println("\t* 1. Nhập cứng                         *");
		System.out.println("\t* 2. Thêm                              *");
		System.out.println("\t* 3. Xóa                               *");
		System.out.println("\t* 4. Sửa                               *");
		System.out.println("\t* 5. Tìm Kiếm                          *");
		System.out.println("\t* 6. Xuất                              *");
		System.out.println("\t* 7. Sắp xếp tăng dần theo giá thành   *");
		System.out.println("\t* 8. Sắp xếp tăng dần theo tựa CD      *");
		System.out.println("\t* 9. Xuất tổng giá thành               *");
		System.out.println("\t* 10.Xuất theo đơn giá cần tìm         *");
		System.out.println("\t* 11. Thoát                            *");
		System.out.println("\t****************************************");
	}

	static void menuSua() {
		System.out.println("\n");
		System.out.println("\t****************************************");
		System.out.println("\t**       Mời nhập thông tin cần sửa    **");
		System.out.println("\t* 1. Số bài hát                         *");
		System.out.println("\t* 2. Tựa bài hát                        *");
		System.out.println("\t* 3. Đơn giá                            *");
		System.out.println("\t* 4. Về menu chính                      *");
		System.out.println("\t*****************************************");
	}

	static void nhapCung(DSachCD ds) {
		CD cd = new CD(1, 3, "Dân Ca", 10000);
		ds.them(cd);
		cd = new CD(2, 10, "Album Sơn Tùng", 5000);
		ds.them(cd);
		cd = new CD(3, 10, "Nhạc cách mạng", 20000);
		ds.them(cd);
	}

	static CD nhapMem(DSachCD ds) {
		Scanner scanner = new Scanner(System.in);
		CD cd = new CD();
		int maCD;
		String tuade;
		System.out.print("\nNhập mã CD: ");
		maCD = scanner.nextInt();
		if (ds.timKiem(maCD) == -1) {
			cd.setMaCD(maCD);
			System.out.print("\nNhập số bài hát: ");
			cd.setSoBH(scanner.nextInt());
			System.out.println("\nNhập tựa đề: ");
			tuade = new Scanner(System.in).nextLine();
			cd.setTuaCD(tuade);
			System.out.print("\nNhập giá thành: ");
			cd.setGiaThanh(scanner.nextDouble());
			System.out.println("\n Thêm thành cônng");
		} else {
			System.out.println("Thêm không thành công mã CD đã trùng.");
			return null;
		}
		return cd;
	}

	static void xoa(DSachCD ds) {
		Scanner scanner = new Scanner(System.in);
		int maCD;
		System.out.print("\nNhập mã CD: ");
		maCD = scanner.nextInt();
		int vt = ds.timKiem(maCD);
		if (vt == -1) {
			System.out.println("\n Mã CD không tồn tại");
		} else {
			String acp;
			System.out.print("\nBạn có chắc chắn muốn xóa CD này khỏi danh sách [y/n]: ");
			acp = new Scanner(System.in).nextLine();
			if (acp.equals("y")) {
				ds.xoa(ds.getDsAC()[vt]);
				System.out.println("Xóa thành công");
			} else {
				System.out.println("Xóa không thành công!! Về menu chính");
			}
		}
	}
	
	static void Sua(DSachCD ds) {
		Scanner scanner = new Scanner(System.in);
		int maCD, chon = -1, vt;
		String tuaBH;
		System.out.print("\nNhập mã CD: ");
		maCD = scanner.nextInt();
		vt = ds.timKiem(maCD);
		CD cdSua = ds.getDsAC()[vt];
		if (vt == -1) {
			System.out.println("\n Mã CD không tồn tại");
		} else {
			System.out.println("Thông tin về đĩa CD của bạn\n" + cdSua);
			do {
				menuSua();
				System.out.print("\nNhập lựa chọn: ");
				chon = scanner.nextInt();
				switch (chon) {
				case 1:
					System.out.print("\nNhập số bài hát: ");
					cdSua.setSoBH(scanner.nextInt());
					break;
				case 2:
					System.out.print("\nNhập tựa đề: ");
					tuaBH = scanner.nextLine();
					break;
				case 3:
					System.out.print("\nNhập giá thành: ");
					cdSua.setGiaThanh(scanner.nextDouble());
					break;
				default:
					ds.sua(cdSua);
					System.out.println("Đã sửa thành công.Trở về menu chính");
				}
			} while (chon < 4);
		}
	}

	static void timKiem(DSachCD ds) {
		Scanner scanner = new Scanner(System.in);
		int maCD;
		System.out.print("\nNhập mã CD: ");
		maCD = scanner.nextInt();
		if (ds.timKiem(maCD) == -1) {
			System.out.println("\n Mã CD không tồn tại");
		} else {
			System.out.println("CD của bạn nằm ở vị trí thứ " + ds.timKiem(maCD) + 1 + " trong danh sách");
		}

	}

	static void xuat(DSachCD ds) {
		for (int i = 0; i < ds.soluongHT; i++) {
			System.out.println(ds.getDsAC()[i]);
		}
	}
	
	static void xuatDSTheoDonGiaCanTim(DSachCD ds) {
		System.out.println("Nhập số tiền mà bạn muốn mua CD: ");
		double soTien = new Scanner(System.in).nextInt();
		CD temp[] = ds.getDSBeHonN(soTien);
		if (ds.soluongHTofDG != 0) {
			for (int i = 0; i < ds.soluongHTofDG; i++) {
				System.out.println(temp[i]);
			}
		} else
			System.out.println("Không có CD nào thỏa mản yêu câu");
	}

	public static void main(String[] args) {
		DSachCD CDList = new DSachCD(2);
		Scanner scanner = new Scanner(System.in);
		int chon = -1;
		try {
			do {
				Menu();
				System.out.print("Nhập lựa chọn: ");
				chon = scanner.nextInt();
				System.out.println("");
				switch (chon) {
				case 1:
					nhapCung(CDList);
					break;
				case 2:
					CD cdn = nhapMem(CDList);
					if(cdn != null)
						CDList.them(cdn);
					else {
						System.out.println("thêm không thành công");
					}
					break;
				case 3:
					xoa(CDList);
					break;
				case 4:
					Sua(CDList);
					break;
				case 5:
					timKiem(CDList);
					break;
				case 6:
					xuat(CDList);
					break;
				case 7:
					CDList.sortTheoGiaThanh();
					System.out.println("Đã sắp xếp thành công");
					break;
				case 8:
					CDList.sortTheoTuaCD();
					System.out.println("Đã sắp xếp thành công");
					break;
				case 9:
					System.out.println("Tổng giá thành là: " + CDList.getMonney());
				case 10:
					xuatDSTheoDonGiaCanTim(CDList);
					break;
				default:
					System.out.println("Cảm ơn bạn đã sử dụng chương trình");
				}
			} while (chon < 11);
	
		} catch (ArithmeticException e1) {
			System.out.println("Không được chia cho không" + e1.getMessage());
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("Lỗi mảng" + e2.getMessage());
		} catch (Exception e) {
			System.out.println("Lỗi không xác định" + e.getMessage());
		}
	}

}
