package repositories;

import entity.ChucVu;
import entity.SanPham;
import entity.SanPhamCT;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.ChiTietSPViewModel;

import java.util.ArrayList;
import java.util.List;

public class SanPhamCTRepository {
    private Session hsession;

    public SanPhamCTRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(SanPhamCT spct) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(spct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(SanPhamCT spct) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(spct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(SanPhamCT spct) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(spct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<SanPhamCT> findAll() {
        String hql = "SELECT o FROM SanPhamCT o";
        TypedQuery<SanPhamCT> query = this.hsession.createQuery(hql, SanPhamCT.class);
        return query.getResultList();
    }

    public SanPhamCT findById(String id) {
        String hql = "SELECT o FROM SanPhamCT o WHERE o.id =?1";
        TypedQuery<SanPhamCT> query = this.hsession.createQuery(hql, SanPhamCT.class);
        query.setParameter(1, id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

//    public SanPhamCT findById(String id) {
//        return this.hsession.find(SanPhamCT.class, id);
//    }
}
