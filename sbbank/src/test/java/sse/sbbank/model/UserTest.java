/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.model;

import sse.sbbank.controller.dbaccess.DBAccess;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hella
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of transferFromUserToUser method, of class User.
     */
    @Test
    public void testTransferToUser() {
        System.out.println("transferToUser");
                
        double amount = 50.0;
        
        User sender = new User(1111,"","","","",150.0,false);
        User recipient = new User(2222,"","","","",150.0, false);

        DBAccess dbinstance = new DBAccess();
                
        dbinstance.insertPersonenToDB(sender);
        dbinstance.insertPersonenToDB(recipient);
        
        sender.transferToUser(2222, amount);
        
        recipient.setKontostand(dbinstance.getUser(2222).getKontostand());

        assertEquals(100.0,sender.getKontostand(),0.0001);
        assertEquals(200.0,recipient.getKontostand(),0.0001);
        assertEquals(100.0,dbinstance.getUser(1111).getKontostand(),0.0001);
        assertEquals(200.0,dbinstance.getUser(2222).getKontostand(),0.0001);
        
        dbinstance.deletePersonFromDB(sender.getKontonummer());
        dbinstance.deletePersonFromDB(recipient.getKontonummer());   
        
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = 5;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        User instance1 = new User(123,"","","","",0.0,false);
        User instance2 = new User(123,"","","","",0.0,false);
        User instance3 = new User(222,"","","","",1.0,false);
        
        boolean result1 = instance1.equals(instance2);
        boolean result2 = instance1.equals(instance3);
        
        assertEquals(true, result1);
        assertEquals(false, result2);
    }
}
