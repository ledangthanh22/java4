package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GioHangChiTiet",uniqueConstraints = {@UniqueConstraint(columnNames = {"IdGioHang","IdChiTietSP"})})

public class GioHangCT {
    @Id
    @ManyToOne @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;
    @Id
    @ManyToOne@JoinColumn(name = "IdChiTietSP")
    private SanPhamCT sanPhamCT;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private double donGia;
    @Column(name = "DonGiaKhiGiam")
    private double donGiaKhiGiam;

    public GioHangCT() {
    }

    public GioHangCT(GioHang gioHang, SanPhamCT sanPhamCT, int soLuong, double donGia, double donGiaKhiGiam) {
        this.gioHang = gioHang;
        this.sanPhamCT = sanPhamCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
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

    public double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
}
