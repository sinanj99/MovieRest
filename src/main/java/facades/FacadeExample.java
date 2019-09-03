package facades;

import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }
    public List<RenameMe> getRenameMeAll(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<RenameMe> renameMe = em.createQuery("SELECT r FROM RenameMe r", RenameMe.class);
            return renameMe.getResultList();
        }finally{  
            em.close();
        }
        
    }
    public RenameMe getRenameMeName(String name){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<RenameMe> renameMe = em.createQuery("SELECT r FROM RenameMe r WHERE r.dummyStr1 = :name", RenameMe.class);
            renameMe.setParameter("name", name);
            return renameMe.getSingleResult();
        }finally{  
            em.close();
        }
    }
    public RenameMe getRenameMeId(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(RenameMe.class,id);
        }finally{  
            em.close();
        }
    }
}
