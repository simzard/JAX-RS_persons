/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;




import entities.Person;
import facades.PersonFacade;
import interfaces.IPersonFacade;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author simon
 */
public class Tester {
    public static void main(String[] args) {
        IPersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory("JAX-RS_personsPU"));
        
        // test of getPerson
        System.out.println(facade.getPerson(1).getFName());
        System.out.println(facade.getPerson(2).getFName());
        
        // test of getPersons
//        List<Person> persons = facade.getPersons();
//        for (Person p : persons) {
//            System.out.println(p.getFName());
//        }
        
        // test of editPerson
//        Person personChanges = new Person(1, "Sim The", "Sorcerer", "11111111");
//        facade.editPerson(personChanges);
        
        // test of addPerson
//        Person personToAdd = new Person("Hans", "Hansen", "666");
//        facade.addPerson(personToAdd);
        
        // test of deletePerson
        //facade.deletePerson(1);
        
        
        
        
        
        
    }
}
