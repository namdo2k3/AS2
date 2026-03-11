package com.example.AS2.repo;

import com.example.AS2.model.HocSinh;
import com.example.AS2.model.LopHoc;
import com.example.AS2.ulti.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LopHocRepository {
    Session session = null;
    public LopHocRepository() {session = HibernateConfig.getFACTORY().openSession();
    }
    public List<LopHoc> getAll() {
        return session.createQuery("select lh from LopHoc lh").list();
    }
    public LopHoc getById(Integer id) {
        return session.find(LopHoc.class, id);
    }
    public void LopHocThem(LopHoc lh) {
        try{
            session.getTransaction().begin();
            session.save(lh);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void LopHocSua(LopHoc lh) {
        try{
            session.getTransaction().begin();
            session.merge(lh);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void LopHocXoa(Integer id) {
        try{
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
