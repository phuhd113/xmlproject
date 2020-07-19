/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import phuhd.entity.TblProduct;

/**
 *
 * @author Duy Phu
 */
public class ProductDAO implements Serializable {

    // 27-40 , singleTon
    public ProductDAO() {
    }
    private static ProductDAO instance;
    private final static Object LOCK = new Object();

    public static ProductDAO getInstance() {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new ProductDAO();
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

    public synchronized void saveProductWhenCrawling(TblProduct product) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TblProduct.findByNameAndImg");
        query.setParameter("name", "%" + product.getName() + "%");
        query.setParameter("image", "%" + product.getImage() + "%");
        try {
            TblProduct tmp = (TblProduct) query.getSingleResult();
            if (tmp != null) {
                System.out.println("Product is existed");
            }

        } catch (Exception e) {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }
    }
    
    public List<TblProduct> getProducts() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TblProduct.findAll");
        try {
            List<TblProduct> products = query.getResultList();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
        }
        return null;
    }

    public TblProduct getProductById(int idProduct){
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TblProduct.findById");
        query.setParameter("id", idProduct);
        TblProduct product = (TblProduct) query.getSingleResult();
        if(product != null){
            return product;
        }
        return null;
    }
    
    public List<TblProduct> filterProduct(String branch, String type){
        EntityManager em = emf.createEntityManager();
        try {
            String tmp = "SELECT t FROM TblProduct t "
                    + "WHERE (:type is NULL OR t.type LIKE :type)"
                    + "AND (:branch is NULL OR t.branch LIKE :branch) ";               
            Query query = em.createQuery(tmp);

            if(!branch.equals("Tất cả")){
                query.setParameter("branch", branch);
            }else{
                query.setParameter("branch", null);
            }
            if(!type.equals("Tất cả")){
                query.setParameter("type", type);
            }else{
                query.setParameter("type", null);
            }                                 
            List<TblProduct> list = query.getResultList();           
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();;
        }
        return null;
        
    }
    public static void main(String[] args) {
        ProductDAO dao = ProductDAO.getInstance();
        dao.filterProduct("Tất cả", "Ryzen 3");
    }
}
