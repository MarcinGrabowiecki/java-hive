/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javahive.javadb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mgr
 */
public class UglyJDBCReader {

    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:testJavaHive";
    private final static String USER = "sa";
    private final static String PASS = "sa";

    public void read() {
    	try{
    	
            //1 - ładowanie sterownika JDBC
            Class.forName(JDBC_DRIVER);
            //3 - łączenie z bazą
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //4 - wykonanie zapytania
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM klienci";
            ResultSet rs = stmt.executeQuery(sql);
            //5 - pobieranie wyników
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("wiek");
                String first = rs.getString("imie");
                String last = rs.getString("nazwisko");
                System.out.printf("%s %s\n",first,last);
            }
            //6 - obsługa wyjątków
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex){
        	ex.printStackTrace();
        }
    }
}
