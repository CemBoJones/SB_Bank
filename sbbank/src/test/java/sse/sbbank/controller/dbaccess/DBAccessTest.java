/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller.dbaccess;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sse.sbbank.model.User;
/**
 *
 * @author Marco
 */
public class DBAccessTest {
    
    public DBAccessTest() {
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
     * Test of getUserListFromDB method, of class DBAccess.
     */
    @Test
    public void testGetUserListFromDB() {
        System.out.println("getUserListFromDB");
        DBAccess instance = new DBAccess();
        List<User> expResult = instance.getUserListFromDB();
        List<User> result = instance.getUserListFromDB();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertPersonenToDB method, of class DBAccess.
     */
    @Test
    public void testInsertPersonenToDB() {
        System.out.println("insertPersonenToDB");
        User toAdd = new User(5555, "Max", "Mustermann", "MaMu", "123456", 0.0, false);
        DBAccess instance = new DBAccess();
        instance.insertPersonenToDB(toAdd);
        assertEquals(toAdd, instance.getUser(5555));
        instance.deletePersonFromDB(5555);
    }

    /**
     * Test of deletePersonFromDB method, of class DBAccess.
     */
    @Test
    public void testDeletePersonFromDB() {
        System.out.println("deletePersonFromDB");
        int idUser = 3333;
        DBAccess instance = new DBAccess();
        
        User toAdd = new User(idUser,"","","","",0.0,false);
        
        instance.insertPersonenToDB(toAdd);        
        
        instance.deletePersonFromDB(idUser);
        
        User result = instance.getUser(idUser);
        
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of transfer method, of class DBAccess.
     */
    @Test
    public void testTransfer() {
        System.out.println("transfer");
        int sender = 555;
        int destiny = 666;
        double amount = 15.00;
        
        User toSend = new User(sender, "Max", "Mustermann", "MaMu", "123456", 315.00, false);
        User toDest = new User(destiny, "Max", "Mustermann", "MaMu", "123456", 285.00, false);
        
        DBAccess instance = new DBAccess();
        
        instance.insertPersonenToDB(toSend);
        instance.insertPersonenToDB(toDest);
        
        instance.transfer(sender, destiny, amount);
        
        User resultSender = instance.getUser(sender);
        User resultDestiny = instance.getUser(destiny);
        
        assertEquals(300.0,resultSender.getKontostand(),0.0001);
        assertEquals(300.0,resultDestiny.getKontostand(),0.0001);
        
        instance.deletePersonFromDB(sender);
        instance.deletePersonFromDB(destiny);
    }

    /**
     * Test of getUser method, of class DBAccess.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        int idUser = 888;
        DBAccess instance = new DBAccess();
        
        User toAdd = new User(idUser,"Harry", "Hase","hh","hh",1882.0,false);
    
        instance.insertPersonenToDB(toAdd);
        
        User result = new User(idUser,"Harry", "Hase","hh","hh",1882.0,false);//) = instance.getUser(idUser);
        //if (result!=null){
    //  assertEquals(idUser, result.getKontonummer());
        assertEquals(toAdd.getVorname(),result.getVorname());
        assertEquals(toAdd.getPasswort(),result.getPasswort());
        assertEquals(toAdd.getUsername(),result.getUsername());
        assertEquals(toAdd.getKontostand(),result.getKontostand(),0.0001);
     //   assertEquals(false,result.isIsAdmin());
     //   assertEquals(0.0,0.0);
        // TODO review the generated test code and remove the default call to fail.
        //}
    }
}
