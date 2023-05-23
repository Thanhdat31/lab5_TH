package lab5_TH;

class PhongMayTinh extends PhongHoc{
	private int thietBiMayTinh;
	
	public PhongMayTinh(int thietBiMayTinh, String maPhong, String dayNha, double dienTich, double soBongDen) {
		super(maPhong,dayNha,dienTich,soBongDen);
		this.thietBiMayTinh = thietBiMayTinh;
	}

	public int getThietBiMayTinh() {
		return thietBiMayTinh;
	}

	public void setThietBiMayTinh(int thietBiMayTinh) {
		this.thietBiMayTinh = thietBiMayTinh;
	}

	@Override
	public String toString() {
		return super.toString() + "PhongMayTinh [thietBiMayTinh=" + thietBiMayTinh + "]";
	}
}
