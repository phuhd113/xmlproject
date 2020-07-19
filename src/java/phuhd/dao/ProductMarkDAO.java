/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import phuhd.entity.TblProduct;
import phuhd.entity.TblProductMark;

/**
 *
 * @author Duy Phu
 */
public class ProductMarkDAO {

    public ProductMarkDAO() {
    }
    private static ProductMarkDAO instance;
    private final static Object LOCK = new Object();

    public static ProductMarkDAO getInstance() {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new ProductMarkDAO();
            }
        }
        return instance;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PhuHDShopCPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public synchronized void saveMarkWhenCrawling(TblProductMark productMark) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TblProductMark.findByName");
        query.setParameter("name", productMark.getName());
        try {
            TblProductMark tmp = (TblProductMark) query.getSingleResult();
            if (tmp != null) {
                System.out.println("Product is existed");
            }
        } catch (Exception e) {
            em.getTransaction().begin();
            em.persist(productMark);
            em.getTransaction().commit();
        }
    }

    public List<TblProductMark> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("TblProductMark.findAll");
            List<TblProductMark> list = query.getResultList();
            if (list != null) {
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProductID(int productMarkId, int productId) {
        EntityManager em = emf.createEntityManager();
        try {
            TblProductMark productMark = em.find(TblProductMark.class, productMarkId);
            if (productMark != null) {
                em.getTransaction().begin();
                productMark.setProductID(productId);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public TblProductMark getMarkProductByProductId(int productId) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("TblProductMark.findByProductID");
            query.setParameter("productID", productId);
            TblProductMark mark = (TblProductMark) query.getResultList().stream().findFirst().orElse(null);
            if(mark != null){
                return mark;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
