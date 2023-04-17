package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ChiTietSP", uniqueConstraints = {@UniqueConstraint(columnNames = {"IdSP", "IdNsx", "IdMauSac", "IdDongSP"})})
public class SanPhamCT {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdSP",
    referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx",
    referencedColumnName = "Id")
    private NSX nSX;

    @ManyToOne
    @JoinColumn(name = "IdMauSac",
    referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP",
    referencedColumnName = "Id")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private String namBH;

    @Column(name = "SoLuongTon")
    private String soLuongTon;

    @Column(name = "GiaNhap")
    private String giaNhap;

    @Column(name = "GiaBan")
    private String giaBan;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "Anh")
    private String anh;

    //    @OneToMany(mappedBy = "sanPhamCT")
//    List<GioHangCT> gioHangCTS;
//    @OneToMany(mappedBy = "sanPhamCT")
//    List<HoaDonCT> hoaDonCTS;
    public SanPhamCT() {
    }

    public SanPhamCT(String id, SanPham sanPham, NSX nSX, MauSac mauSac, DongSP dongSP, String namBH, String soLuongTon, String giaNhap, String giaBan, String moTa, String anh) {
        this.id = id;
        this.sanPham = sanPham;
        this.nSX = nSX;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.anh = anh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NSX getnSX() {
        return nSX;
    }

    public void setnSX(NSX nSX) {
        this.nSX = nSX;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public String getNamBH() {
        return namBH;
    }

    public void setNamBH(String namBH) {
        this.namBH = namBH;
    }

    public String getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(String soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    //    public List<GioHangCT> getGioHangCTS() {
//        return gioHangCTS;
//    }
//
//    public void setGioHangCTS(List<GioHangCT> gioHangCTS) {
//        this.gioHangCTS = gioHangCTS;
//    }
//
//    public List<HoaDonCT> getHoaDonCTS() {
//        return hoaDonCTS;
//    }
//
//    public void setHoaDonCTS(List<HoaDonCT> hoaDonCTS) {
//        this.hoaDonCTS = hoaDonCTS;
//    }
}
