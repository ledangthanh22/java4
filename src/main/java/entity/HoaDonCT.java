package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet",uniqueConstraints = {@UniqueConstraint(columnNames = {"IdHoaDon","IdChiTietSP "})})
public class HoaDonCT {
    @Id
    @ManyToOne@JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;
    @Id
    @ManyToOne@JoinColumn(name = "IdChiTietSP")
    private SanPhamCT sanPhamCT;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private double donGia;

    public HoaDonCT() {
    }

    public HoaDonCT(HoaDon hoaDon, SanPhamCT sanPhamCT, int soLuong, double donGia) {
        this.hoaDon = hoaDon;
        this.sanPhamCT = sanPhamCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPhamCT getSanPhamCT() {
        return sanPhamCT;
    }

    public void setSanPhamCT(SanPhamCT sanPhamCT) {
        this.sanPhamCT = sanPhamCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
