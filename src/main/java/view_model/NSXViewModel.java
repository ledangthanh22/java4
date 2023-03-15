package view_model;

public class NSXViewModel {
    private String ma;
    private String ten;

    public NSXViewModel() {
    }

    public NSXViewModel(String ma, String ten) {
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
