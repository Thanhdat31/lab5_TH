package lab5_TH;

class PhongHocLyThuyet extends PhongHoc{
	private boolean coMayChieu;
	public PhongHocLyThuyet( boolean coMayChieu, String maPhong, String dayNha, double dienTich, double soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;		
	}
	public boolean isCoMayChieu() {
		return coMayChieu;
	}
	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}
	@Override
	public String toString() {
		return super.toString() + "PhongHocLyThuyet [coMayChieu=" + coMayChieu + "]";
	}
	
}
