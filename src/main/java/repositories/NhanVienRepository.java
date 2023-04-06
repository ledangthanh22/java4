package repositories;

import entity.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class NhanVienRepository {
    Session hSession;

    public NhanVienRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NhanVien nv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(NhanVien nv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(nv);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(NhanVien nv) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<NhanVien> findAll() {
        String hql = "From NhanVien";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql);
        return query.getResultList();
    }

    public NhanVien findByMa(String ma) {
        String hql = "From NhanVien o WHERE o.ma = ?1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien findById(String id) {
        return this.hSession.find(NhanVien.class, id);
    }

    public NhanVien login(String ma, String matKhau) {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);
        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
