package facades;

import dto.DTO;
import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
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
            long movieCount = (long) em.createQuery("SELECT COUNT(m) FROM Movie m").getSingleResult();
            return movieCount;
        } finally {
            em.close();
        }

    }

    public List<DTO> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<DTO> movies = em.createQuery("SELECT new dto.DTO(m) FROM Movie m", DTO.class);
            return movies.getResultList();
        } finally {
            em.close();
        }

    }

    public DTO getByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<DTO> movie = em.createQuery("SELECT new dto.DTO(m) FROM Movie m WHERE m.name = :name", DTO.class);
            movie.setParameter("name", name);
            return movie.getSingleResult();
        } finally {
            em.close();
        }
    }

    public DTO getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return new DTO(em.find(Movie.class, id));
        } finally {
            em.close();
        }
    }
}
