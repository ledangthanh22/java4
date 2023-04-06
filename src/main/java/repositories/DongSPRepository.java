package repositories;

import entity.DongSP;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    private Session hsession;

    public DongSPRepository() {
        this.hsession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(DongSP dsp) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.persist(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(DongSP dsp) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.merge(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSP dsp) {
        Transaction transaction = this.hsession.getTransaction();
        try {
            transaction.begin();
            this.hsession.delete(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<DongSP> findAll() {
        String hql = "SELECT o FROM DongSP o";
        TypedQuery<DongSP> query = this.hsession.createQuery(hql, DongSP.class);
        return query.getResultList();
    }

    public DongSP findByMa(String ma) {
        String hql = "SELECT o FROM DongSP o WHERE o.ma = ?1";
        TypedQuery<DongSP> query = this.hsession.createQuery(hql, DongSP.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public DongSP findById(UUID id) {
        return this.hsession.find(DongSP.class, id);
    }
}
