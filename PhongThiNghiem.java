package lab5_TH;

class PhongThiNghiem extends PhongHoc{
	private int sucChua;
	private boolean bonRua;
	
	public PhongThiNghiem(int sucChua, boolean bonRua, String maPhong, String dayNha, double dienTich, double soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.bonRua = bonRua;
		this.sucChua = sucChua;
		
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isBonRua() {
		return bonRua;
	}

	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	@Override
	public String toString() {
		return super.toString() + "PhongThiNghiem [sucChua=" + sucChua + ", bonRua=" + bonRua + "]";
	}	
}
