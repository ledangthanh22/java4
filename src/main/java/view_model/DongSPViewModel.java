package view_model;

public class DongSPViewModel {
    private String ma;
    private String ten;

    public DongSPViewModel() {
    }

    public DongSPViewModel(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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
}
