import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnect {

    public DBConnect(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("./");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
    }
}
