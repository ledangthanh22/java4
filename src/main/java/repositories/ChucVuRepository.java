package repositories;

import entity.ChucVu;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hsession;

    public ChucVuRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChucVu cv) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(ChucVu cv) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVu cv) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<ChucVu> findAll() {
        String hql = "SELECT o FROM ChucVu o";
        TypedQuery<ChucVu> query = this.hsession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findByMa(String ma) {
        String hql = "SELECT o FROM ChucVu o WHERE o.ma = ?1";
        TypedQuery<ChucVu> query = this.hsession.createQuery(hql, ChucVu.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public ChucVu findById(UUID id) {
        return this.hsession.find(ChucVu.class, id);
    }
}
