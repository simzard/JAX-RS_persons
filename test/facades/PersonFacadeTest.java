/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import interfaces.IPersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class PersonFacadeTest {
   
    static EntityManagerFactory emf;
    static IPersonFacade facade;
    
    public PersonFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("JAX-RS_personsPU2");
        facade = new PersonFacadeAlt(emf);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testGetEntityManager() {
    }

    @Test
    public void testAddPerson() {
        Person p1 = new Person("te", "st", "99887766");
        Person resultPerson = facade.addPerson(p1);
        assertTrue(resultPerson.getFName().equals(p1.getFName()));
        assertTrue(resultPerson.getLName().equals(p1.getLName()));
        assertTrue(resultPerson.getPhone().equals(p1.getPhone()));
        
    }

    @Test
    public void testDeletePerson() {
    }

    @Test
    public void testGetPerson() {
    }

    @Test
    public void testGetPersons() {
    }

    @Test
    public void testEditPerson() {
    }
    
}
