/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import interfaces.IPersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author simon
 */
public class PersonFacade implements IPersonFacade {

    @PersistenceContext(name = "persistence/production", unitName = "JAX-RS_personsPU")
            
    EntityManager em;
    
    private EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = getEntityManager();
        // Use the entity manager  
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public Person deletePerson(int id) {
        EntityManager em = getEntityManager();
        Person personToDelete = em.find(Person.class, id);

        // Use the entity manager  
        try {
            em.getTransaction().begin();
            em.remove(personToDelete);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return personToDelete;
    }

    @Override
    public Person getPerson(int id) {

        
        Person personToGet = em.find(Person.class, id);

        return personToGet;

    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = null;
        EntityManager em = getEntityManager();
        try {

            // Use the entity manager  
            Query query
                    = em.createQuery("Select c FROM Person c");
            persons = query.getResultList();

        } finally {
            em.close();
        }
        return persons;
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = getEntityManager();
        Person persToEdit = em.find(Person.class, p.getId());

        try {
            // overwrite and persist
            em.getTransaction().begin();
            persToEdit.setFName(p.getFName());
            persToEdit.setLName(p.getLName());
            persToEdit.setPhone(p.getPhone());
            em.persist(persToEdit);
            em.getTransaction().commit();

        } finally {
            em.close();
        }

        return persToEdit;

    }

}
