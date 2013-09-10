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
public class JDBCReader {

    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:mysql://serwer/db";
    private final static String USER = "username";
    private final static String PASS = "password";

    public void read() {
        //1 - zmienne
        Statement stmt = null;
        Connection conn = null;
        try {
            //2 - ³adowanie sterownika JDBC
            Class.forName(JDBC_DRIVER);
            //3 - ³¹czenie z baz¹
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //4 - wykonanie zapytania
            stmt = conn.createStatement();
            String sql = "SELECT * FROM tabela";
            ResultSet rs = stmt.executeQuery(sql);
            //5 - pobieranie wyników
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                System.out.printf("%s %s\n",first,last);
            }
            //6 - obs³uga wyj¹tków
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
