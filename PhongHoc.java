package lab5_TH;

public class PhongHoc {
   private String maPhong, dayNha;
   private double dienTich, soBongDen;
   
   public PhongHoc(String maPhong,String dayNha,double dienTich, double soBongDen) {
	   super();
	   this.dayNha = dayNha;
	   this.dienTich = dienTich;
	   this.maPhong = dayNha;
	   this.soBongDen = soBongDen;
	   	   
   }

public String getMaPhong() {
	return maPhong;
}

public void setMaPhong(String maPhong) {
	this.maPhong = maPhong;
}

public String getDayNha() {
	return dayNha;
}

public void setDayNha(String dayNha) {
	this.dayNha = dayNha;
}

public double getDienTich() {
	return dienTich;
}

public void setDienTich(double dienTich) {
	this.dienTich = dienTich;
}

public double getSoBongDen() {
	return soBongDen;
}

public void setSoBongDen(double soBongDen) {
	this.soBongDen = soBongDen;
}

@Override
public String toString() {
	return "PhongHoc [maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen=" + soBongDen
			+ "]";
}
}


