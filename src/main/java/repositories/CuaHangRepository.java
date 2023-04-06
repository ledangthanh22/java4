package repositories;

import entity.CuaHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hsession;

    public CuaHangRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(CuaHang ch) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(CuaHang ch) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(CuaHang ch) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<CuaHang> findAll() {
        String hql = "SELECT o FROM CuaHang o";
        TypedQuery<CuaHang> query = this.hsession.createQuery(hql, CuaHang.class);
        return query.getResultList();
    }

    public CuaHang findByMa(String ma) {
        String hql = "SELECT o FROM CuaHang o WHERE o.ma = ?1";
        TypedQuery<CuaHang> query = this.hsession.createQuery(hql, CuaHang.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public CuaHang findById(UUID id) {
        return this.hsession.find(CuaHang.class, id);
    }
}
