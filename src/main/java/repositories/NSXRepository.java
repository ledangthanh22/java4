package repositories;

import entity.NSX;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class NSXRepository {
    private Session hsession;

    public NSXRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NSX nsx) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(NSX nsx) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NSX nsx) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<NSX> findAll() {
        String hql = "SELECT o FROM NSX o";
        TypedQuery<NSX> query = this.hsession.createQuery(hql, NSX.class);
        return query.getResultList();
    }

    public NSX findByMa(String ma) {
        String hql = "SELECT o FROM NSX o WHERE o.ma = ?1";
        TypedQuery<NSX> query = this.hsession.createQuery(hql, NSX.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public NSX findById(UUID id) {
        return this.hsession.find(NSX.class, id);
    }
}
