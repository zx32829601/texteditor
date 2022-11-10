
import model.TextEnitity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;


public class test {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("objectdb:myDbFile.odb");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

entityManager.getTransaction().begin();

        Query q1=entityManager.createQuery("SELECT COUNT(p)FROM TextEnitity p");
        TextEnitity textEnitity=entityManager.find(TextEnitity.class,1);
        textEnitity.setText("This is the Group five's document editor information If you want to change about this you can download from the git and commit and push \nccccc@gmail.com 09-xxxxxxxxxxxxx" +
                "");
        entityManager.getTransaction().commit();
        System.out.println(textEnitity.getText());
        System.out.println(q1.getSingleResult());




    }
}
