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
        User toAdd = new User(1, "Max", "Mustermann", "MaMu", "123456", 0.0, false);
        DBAccess instance = new DBAccess();
        instance.insertPersonenToDB(toAdd);
        assertEquals(toAdd, instance.getUserListFromDB().get(1));
    }
}
