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

import com.javahive.javadb.mybatis.KlientReader;

import dbutil.DBCreator;
import static org.junit.Assert.*;

/**
 *
 * @author mgr
 */
public class StartTest {
    
    public StartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws ClassNotFoundException, CommandLineParsingException, IOException, SQLException, LiquibaseException {
			new DBCreator().createTestDB();
    }


    @Test
    public void testJDBC() throws Exception {
        new UglyJDBCReader().read();
        assertTrue(true);
        
    }
    
    @Test
    public void testMybatis(){
    	new KlientReader().read();    	
    }
    
}
