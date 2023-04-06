package repositories;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import entity.MauSac;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    private Session hsession;

    public MauSacRepository() {
         this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac ms) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac ms) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac findById(UUID id) {
        return this.hsession.find(MauSac.class, id);
    }

    public List<MauSac> findAll() {
        String hql = "SELECT o FROM MauSac o";
        TypedQuery<MauSac> query = hsession.createQuery(hql,MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(String ma) {
        String hql = "SELECT o FROM MauSac o WHERE o.ma = ?1";
        TypedQuery<MauSac> query = hsession.createQuery(hql,MauSac.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
