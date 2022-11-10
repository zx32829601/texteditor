package database;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnect {
    EntityManagerFactory emf;
    EntityManager em;

    public DBConnect(){
         emf= Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
         em=emf.createEntityManager();
        em.getTransaction().begin();
    }
}
