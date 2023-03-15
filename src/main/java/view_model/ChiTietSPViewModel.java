package view_model;

public class ChiTietSPViewModel {
    private String tenSanPham;
    private String tenNSX;
    private String tenMauSac;
    private String tenDongSP;
    private int namBH;
    private int soLuongTon;
    private double giaNhap;
    private double giaBan;
    private String moTa;

    public ChiTietSPViewModel() {
    }

    public ChiTietSPViewModel(String tenSanPham, String tenNSX, String tenMauSac, String tenDongSP, int namBH, int soLuongTon, double giaNhap, double giaBan, String moTa) {
        this.tenSanPham = tenSanPham;
        this.tenNSX = tenNSX;
        this.tenMauSac = tenMauSac;
        this.tenDongSP = tenDongSP;
        this.namBH = namBH;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
