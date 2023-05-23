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
                if (phongMayTinh.getThietBiMayTinh() >= phongHoc.getDienTich() / 1.5
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
                phongMayTinh.setThietBiMayTinh(soMayTinhMoi);
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
                if (phongMayTinh.getThietBiMayTinh() == soMayTinh) {
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

