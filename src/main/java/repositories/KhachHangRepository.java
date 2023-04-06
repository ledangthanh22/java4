package repositories;

import entity.KhachHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class KhachHangRepository {
    private Session hsession;

    public KhachHangRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(KhachHang kh) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(KhachHang kh) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(KhachHang kh) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<KhachHang> findAll() {
        String hql = "SELECT o FROM KhachHang o";
        TypedQuery<KhachHang> query = this.hsession.createQuery(hql, KhachHang.class);
        return query.getResultList();
    }

    public KhachHang findByMa(String ma) {
        String hql = "SELECT o FROM KhachHang o WHERE o.ma = ?1";
        TypedQuery<KhachHang> query = this.hsession.createQuery(hql, KhachHang.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang findById(String id) {
        return this.hsession.find(KhachHang.class, id);
    }
}
