package repositories;


import entity.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;


public class SanPhamRepository {
    Session hsession;

    public SanPhamRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(SanPham sp) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            ;
            this.hsession.persist(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SanPham sp) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            ;
            this.hsession.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(SanPham sp) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            ;
            this.hsession.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<SanPham> findAll() {
        String hql = "SELECT o FROM SanPham o";
        TypedQuery<SanPham> query = this.hsession.createQuery(hql, SanPham.class);
        return query.getResultList();
    }

    public SanPham findByMa(String ma) {
        String hql = "SELECT o FROM SanPham o WHERE o.ma =?1";
        TypedQuery<SanPham> query = this.hsession.createQuery(hql, SanPham.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public SanPham findById(UUID id) {
        return this.hsession.find(SanPham.class, id);
    }
}
