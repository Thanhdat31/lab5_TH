package lab5_TH;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class QuanLyPhongHoc {
    private List<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        danhSachPhongHoc = new ArrayList<>();
    }

    public boolean themPhongHoc(PhongHoc phongHoc) {
        if (!kiemTraTonTai(phongHoc.getMaPhong())) {
            danhSachPhongHoc.add(phongHoc);
            return true;
        }
        return false;
    }

    public PhongHoc timPhongHocTheoMa(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                return phongHoc;
            }
        }
        return null;
    }

    public void inToanBoDanhSachPhongHoc() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            System.out.println(phongHoc);
        }
    }

    public void inDanhSachPhongHocDatChuan() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongHocLyThuyet) {
                PhongHocLyThuyet phongLyThuyet = (PhongHocLyThuyet) phongHoc;
                if (phongLyThuyet.isCoMayChieu() && phongHoc.getSoBongDen() >= phongHoc.getDienTich() / 10) {
                    System.out.println(phongHoc);
                }
            } else if (phongHoc instanceof PhongMayTinh) {
                PhongMayTinh phongMayTinh = (PhongMayTinh) phongHoc;
                if (phongMayTinh.getSoMayTinh() >= phongHoc.getDienTich() / 1.5
                        && phongHoc.getSoBongDen() >= phongHoc.getDienTich() / 10) {
                    System.out.println(phongHoc);
                }
            } else if (phongHoc instanceof PhongThiNghiem) {
                PhongThiNghiem phongThiNghiem = (PhongThiNghiem) phongHoc;
                if (phongThiNghiem.isBonRua() && phongHoc.getSoBongDen() >= phongHoc.getDienTich() / 10) {
                    System.out.println(phongHoc);
                }
            }
        }
    }

    public void sapXepTheoDayNhaTangDan() {
        danhSachPhongHoc.sort(Comparator.comparing(PhongHoc::getDayNha));
    }

    public void sapXepTheoDienTichGiamDan() {
        danhSachPhongHoc.sort(Comparator.comparing(PhongHoc::getDienTich).reversed());
    }

    public void sapXepTheoSoBongDenTangDan() {
        danhSachPhongHoc.sort(Comparator.comparing(PhongHoc::getSoBongDen));
    }

    public void capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongMayTinh && phongHoc.getMaPhong().equals(maPhong)) {
                PhongMayTinh phongMayTinh = (PhongMayTinh) phongHoc;
                phongMayTinh.setSoMayTinh(soMayTinhMoi);
                break;
            }
        }
    }

    public boolean xoaPhongHoc(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                danhSachPhongHoc.remove(phongHoc);
                return true;
            }
        }
        return false;
    }

    public void inTongSoPhongHoc() {
        System.out.println("Tong so phong hoc: " + danhSachPhongHoc.size());
    }

    public void inDanhSachPhongMayCoSoMayTinh(int soMayTinh) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongMayTinh) {
                PhongMayTinh phongMayTinh = (PhongMayTinh) phongHoc;
                if (phongMayTinh.getSoMayTinh() == soMayTinh) {
                    System.out.println(phongHoc);
                }
            }
        }
    }

    private boolean kiemTraTonTai(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                return true;
            }
        }
        return false;
    }
}

public class QuanLyPhongHocProgram {
    public static void main(String[] args) {
        QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();

        int luaChon = 0;
        do {
            System.out.println("======== MENU ========");
            System.out.println("1. Them phong hoc");
            System.out.println("2. Tim kiem phong hoc");
            System.out.println("3. In toan bo danh sach phong hoc");
            System.out.println("4. In danh sach phong hoc dat chuan");
            System.out.println("5. Sap xep danh sach tang dan theo day nha");
            System.out.println("6. Sap xep danh sach giam dan theo dien tich");
            System.out.println("7. Sap xep danh sach tang dan theo so bong den");
            System.out.println("8. Cap nhat so may tinh cho mot phong may tinh");
            System.out.println("9. Xoa mot phong hoc");
            System.out.println("10. In tong so phong hoc");
            System.out.println("11. In danh sach phong may co so may tinh");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = Integer.parseInt(System.console().readLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap ma phong: ");
                    String maPhong = System.console().readLine();
                    System.out.print("Nhap day nha: ");
                    String dayNha = System.console().readLine();
                    System.out.print("Nhap dien tich: ");
                    double dienTich = Double.parseDouble(System.console().readLine());
                    System.out.print("Nhap so bong den: ");
                    int soBongDen = Integer.parseInt(System.console().readLine());

                    System.out.println("Loai phong hoc:");
                    System.out.println("1. Phong ly thuyet");
                    System.out.println("2. Phong may tinh");
                    System.out.println("3. Phong thi nghiem");
                    System.out.print("Nhap lua chon cua ban: ");
                    int loaiPhong = Integer.parseInt(System.console().readLine());

                    switch (loaiPhong) {
                        case 1:
                            System.out.print("Co may chieu? (true/false): ");
                            boolean coMayChieu = Boolean.parseBoolean(System.console().readLine());
                            PhongHocLyThuyet phongLyThuyet = new PhongHocLyThuyet(maPhong, dayNha, dienTich, soBongDen,
                                    coMayChieu);
                            if (quanLyPhongHoc.themPhongHoc(phongLyThuyet)) {
                                System.out.println("Them phong hoc thanh cong!");
                            } else {
                                System.out.println("Ma phong da ton tai!");
                            }
                            break;
                        case 2:
                            System.out.print("Nhap so may tinh: ");
                            int soMayTinh = Integer.parseInt(System.console().readLine());
                            PhongMayTinh phongMayTinh = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen,
                                    soMayTinh);
                            if (quanLyPhongHoc.themPhongHoc(phongMayTinh)) {
                                System.out.println("Them phong hoc thanh cong!");
                            } else {
                                System.out.println("Ma phong da ton tai!");
                            }
                            break;
                        case 3:
                            System.out.print("Nhap chuyen nganh: ");
                            String chuyenNganh = System.console().readLine();
                            System.out.print("Nhap suc chua: ");
                            int sucChua = Integer.parseInt(System.console().readLine());
                            System.out.print("Co bon rua? (true/false): ");
                            boolean coBonRua = Boolean.parseBoolean(System.console().readLine());
                            PhongThiNghiem phongThiNghiem = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen,
                                    chuyenNganh, sucChua, coBonRua);
                            if (quanLyPhongHoc.themPhongHoc(phongThiNghiem)) {
                                System.out.println("Them phong hoc thanh cong!");
                            } else {
                                System.out.println("Ma phong da ton tai!");
                            }
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Nhap ma phong can tim: ");
                    String maPhongTimKiem = System.console().readLine();
                    PhongHoc phongHocTimKiem = quanLyPhongHoc.timPhongHocTheoMa(maPhongTimKiem);
                    if (phongHocTimKiem != null) {
                        System.out.println(phongHocTimKiem);
                    } else {
                        System.out.println("Khong tim thay phong hoc!");
                    }
                    break;
                case 3:
                    quanLyPhongHoc.inToanBoDanhSachPhongHoc();
                    break;
                case 4:
                    quanLyPhongHoc.inDanhSachPhongHocDatChuan();
                    break;
                case 5:
                    quanLyPhongHoc.sapXepTheoDayNhaTangDan();
                    System.out.println("Da sap xep danh sach tang dan theo day nha!");
                    break;
                case 6:
                    quanLyPhongHoc.sapXepTheoDienTichGiamDan();
                    System.out.println("Da sap xep danh sach giam dan theo dien tich!");
                    break;
                case 7:
                    quanLyPhongHoc.sapXepTheoSoBongDenTangDan();
                    System.out.println("Da sap xep danh sach tang dan theo so bong den!");
                    break;
                case 8:
                    System.out.print("Nhap ma phong may tinh can cap nhat: ");
                    String maPhongCapNhat = System.console().readLine();
                    System.out.print("Nhap so may tinh moi: ");
                    int soMayTinhMoi = Integer.parseInt(System.console().readLine());
                    quanLyPhongHoc.capNhatSoMayTinh(maPhongCapNhat, soMayTinhMoi);
                    System.out.println("Da cap nhat so may tinh cho phong hoc!");
                    break;
                case 9:
                    System.out.print("Nhap ma phong can xoa: ");
                    String maPhongXoa = System.console().readLine();
                    if (quanLyPhongHoc.xoaPhongHoc(maPhongXoa)) {
                        System.out.println("Xoa phong hoc thanh cong!");
                    } else {
                        System.out.println("Khong tim thay phong hoc can xoa!");
                    }
                    break;
                case 10:
                    quanLyPhongHoc.inTongSoPhongHoc();
                    break;
                case 11:
                    System.out.print("Nhap so may tinh: ");
                    int soMayTinhIn = Integer.parseInt(System.console().readLine());
                    quanLyPhongHoc.inDanhSachPhongMayCoSoMayTinh(soMayTinhIn);
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (luaChon != 0);
    }
}

