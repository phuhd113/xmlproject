/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuhd.uitls;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Duy Phu
 */
public class DBHelper {

    public DBHelper() {
    }
    private static EntityManagerFactory emf;
    //private static final Object LOCK = new Object();

    public static EntityManager getEntityManager() {
            if (emf == null) {
                try {
                    emf = Persistence.createEntityManagerFactory("PhuHDShopCPU");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        return emf.createEntityManager();
    }

}
