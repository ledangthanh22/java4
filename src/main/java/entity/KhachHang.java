package entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="KhachHang")
public class KhachHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ho")
    private String ho;

    @Column(name="TenDem")
    private String tenDem;

    @Column(name="Ten")
    private String ten;

    @Column(name="NgaySinh")
//    @Temporal(TemporalType.DATE)
    private String ngaySinh ;

    @Column(name="Sdt")
    private String soDienThoai;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="ThanhPho")
    private String thanhPho;

    @Column(name="QuocGia")
    private String quocGia;

    @Column(name="MatKhau")
    private String matKhau;

//    @OneToMany(mappedBy = "khachHang")
//    List<HoaDon> hoaDons;
//    @OneToMany(mappedBy = "khachHang")
//    List<GioHang> gioHangs;
    public KhachHang() {
    }

    public KhachHang(UUID id, String ma, String ho, String tenDem, String ten, String ngaySinh, String soDienThoai, String diaChi, String thanhPho, String quocGia, String matKhau) {
        this.id = id;
        this.ma = ma;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
//    public List<HoaDon> getHoaDons() {
//        return hoaDons;
//    }
//
//    public void setHoaDons(List<HoaDon> hoaDons) {
//        this.hoaDons = hoaDons;
//    }
//
//    public List<GioHang> getGioHangs() {
//        return gioHangs;
//    }
//
//    public void setGioHangs(List<GioHang> gioHangs) {
//        this.gioHangs = gioHangs;
//    }
}
