package facades;

import dto.DTO;
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
    private FacadeExample() {
    }

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
    public long getCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }

    }

    public List<DTO> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<DTO> renameMe = em.createQuery("SELECT new dto.DTO(r) FROM RenameMe r", DTO.class);
            return renameMe.getResultList();
        } finally {
            em.close();
        }

    }

    public DTO getByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<DTO> renameMe = em.createQuery("SELECT new dto.DTO(r) FROM RenameMe r WHERE r.dummyStr1 = :name", DTO.class);
            renameMe.setParameter("name", name);
            return renameMe.getSingleResult();
        } finally {
            em.close();
        }
    }

    public DTO getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new DTO(em.find(RenameMe.class, id));
        } finally {
            em.close();
        }
    }
}
