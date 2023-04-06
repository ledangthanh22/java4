package repositories;

import view_model.ChiTietSPViewModel;
import view_model.GioHangChiTietViewModel;
import view_model.KhachHangViewModel;

import java.util.ArrayList;

public class GioHangChiTietRepository {
    ArrayList<GioHangChiTietViewModel> listGHCT = new ArrayList<>();

    public GioHangChiTietRepository() {
        listGHCT.add(new GioHangChiTietViewModel("AsusTUFGaming",2,20000000,20));
    }
    public ArrayList<GioHangChiTietViewModel> findAll(){
        return this.listGHCT;
    }
    public void delete(GioHangChiTietViewModel ghct){
        for (int i = 0; i < this.listGHCT.size(); i++) {
            GioHangChiTietViewModel item = this.listGHCT.get(i);
            if (item.getTenSanPham().contains(ghct.getTenSanPham())){
                this.listGHCT.remove(i);
            }
        }
    }
    public void insert(GioHangChiTietViewModel gh){
        this.listGHCT.add(gh);
    }
    public GioHangChiTietViewModel findByTen(String ten) {
        for (int i = 0; i < this.listGHCT.size(); i++) {
            GioHangChiTietViewModel item = this.listGHCT.get(i);
            if (item.getTenSanPham().equals(ten)) {
                return this.listGHCT.get(i);
            }
        }
        return null;
    }
}
