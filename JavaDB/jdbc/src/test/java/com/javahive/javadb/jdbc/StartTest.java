/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javahive.javadb.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import liquibase.exception.CommandLineParsingException;
import liquibase.exception.LiquibaseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author mgr
 */
public class StartTest {
    
    public StartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    	try {
			DBCreator.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
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


    @Test
    public void testJDBC() throws Exception {
        new UglyJDBCReader().read();
        
    }
    
}
