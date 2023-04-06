package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUI
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    @OneToMany(mappedBy = "mauSac",
    fetch = FetchType.LAZY)
    List<SanPhamCT> sanPhamCTS;
    public MauSac() {
    }

    public MauSac(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<SanPhamCT> getSanPhamCTS() {
        return sanPhamCTS;
    }

    public void setSanPhamCTS(List<SanPhamCT> sanPhamCTS) {
        this.sanPhamCTS = sanPhamCTS;
    }
}
