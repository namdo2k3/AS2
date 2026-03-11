package com.example.AS2.repo;

import com.example.AS2.model.HocSinh;
import com.example.AS2.ulti.HibernateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class HocSinhRepository {
    Session session = null;
    public HocSinhRepository() {session = HibernateConfig.getFACTORY().openSession();
    }
    public List<HocSinh> getAll() {
        return session.createQuery("select hs from HocSinh hs").list();
    }
    public HocSinh getById(Integer id) {
        return session.find(HocSinh.class, id);
    }
    public void HocSinhThem(HocSinh hs) {
        try{
            session.getTransaction().begin();
            session.save(hs);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void HocSinhSua(HocSinh hs) {
        try{
            session.getTransaction().begin();
            session.merge(hs);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void HocSinhXoa(Integer id) {
        try{
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public List<HocSinh> thangnambingao(HocSinh hs) {
        Query query = session.createQuery("SELECT hs FROM HocSinh order by hs.hoTen");
        return query.getResultList();
    }
}
