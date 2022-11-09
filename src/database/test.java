import model.DocumentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;


public class test {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        DocumentModel documentModel = new DocumentModel();

        entityManager.getTransaction().begin();
        entityManager.persist(documentModel);
        entityManager.getTransaction().commit();




    }
}
