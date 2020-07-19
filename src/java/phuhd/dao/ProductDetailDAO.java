/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import phuhd.entity.TblProductDetail;

/**
 *
 * @author Duy Phu
 */
public class ProductDetailDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PhuHDShopCPU");

    public ProductDetailDAO() {
    }
    private static ProductDetailDAO instance;
    private final static Object LOCK = new Object();

    public static ProductDetailDAO getInstance() {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new ProductDetailDAO();
            }
        }
        return instance;
    }

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

    public void saveProductDetail(TblProductDetail detail) {
        try {
            persist(detail);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public TblProductDetail getProductDetail(int idProduct) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("TblProductDetail.findByProductID");
            query.setParameter("productID", idProduct);
            TblProductDetail detail = (TblProductDetail) query.getResultList().stream().findFirst().orElse(null);
            if (detail != null) {
                System.out.println("Detail : " + detail.getMemoryType());
            }

            return detail;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    // get entity to set selectchoose html
    public HashMap<String, List> getEntity() {
        List<String> tmp = new ArrayList<>();
        tmp.add("core");
        tmp.add("thread");
        tmp.add("memoryType");
        tmp.add("socket");
        HashMap<String, List> mapList = new HashMap<>();
        // create query
        EntityManager em = emf.createEntityManager();
        try {
            Query query = null;
            for (int i = 0; i < tmp.size(); i++) {
                query = em.createQuery("SELECT DISTINCT t." + tmp.get(i) + " FROM TblProductDetail t");
                List tmpList = query.getResultList();
                if (tmpList != null) {
                    mapList.put(tmp.get(i), tmpList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return mapList;
    }
    
    public List<TblProductDetail> filterProduct(String core,String thread,String memoryType,String socket,String overClocking){
        EntityManager em = emf.createEntityManager();
        try {
            String tmp = "SELECT t FROM TblProductDetail t "
                    + "WHERE (:core is NULL OR t.core LIKE :core) "
                    + "AND (:thread is NULL OR t.thread LIKE :thread) "
                    + "AND (:memoryType is NULL OR t.memoryType LIKE :memoryType) "
                    + "AND (:socket is NULL OR t.socket LIKE :socket) "
                    + "AND (:overClocking is NULL OR t.overClocking = :overClocking) ";
            Query query = em.createQuery(tmp);
            if(!core.equals("Tất cả")){
                query.setParameter("core", Integer.parseInt(core));
            }else{
                query.setParameter("core", null);
            }
            if(!thread.equals("Tất cả")){
                query.setParameter("thread", Integer.parseInt(thread));
            }else{
                query.setParameter("thread", null);
            }
            if(!memoryType.equals("Tất cả")){
                query.setParameter("memoryType", memoryType);
            }else{
                query.setParameter("memoryType", null);
            }
            if(!socket.equals("Tất cả")){
                query.setParameter("socket", socket);
            }else{
                query.setParameter("socket", null);
            }
            if(!overClocking.equals("Tất cả")){
                query.setParameter("overClocking", Boolean.parseBoolean(overClocking));
            }else{
                query.setParameter("overClocking", null);
            }
            List<TblProductDetail> list = query.getResultList();
           
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();;
        }
        return null;
    }

    public static void main(String[] args) {
        ProductDetailDAO dao = ProductDetailDAO.getInstance();
        dao.filterProduct("Tất cả", "Tất cả", "Tất cả", "Tất cả", "Tất cả");
    }

}
