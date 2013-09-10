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
public class BadJDBCReader {

    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:testJavaHive";
    private final static String USER = "sa";
    private final static String PASS = "sa";

    public void read() {
        //1 - zmienne
        Statement stmt = null;
        Connection conn = null;
        try {
            //2 - �adowanie sterownika JDBC
            Class.forName(JDBC_DRIVER);
            //3 - ��czenie z baz�
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //4 - wykonanie zapytania
            stmt = conn.createStatement();
            String sql = "SELECT * FROM klienci";
            ResultSet rs = stmt.executeQuery(sql);
            //5 - pobieranie wynik�w
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("wiek");
                String first = rs.getString("imie");
                String last = rs.getString("nazwisko");
                System.out.printf("%s %s\n",first,last);
            }
            //6 - obs�uga wyj�tk�w
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Obs�uga b��d�w jdbc
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
			// W przypadku nieznalezienia sterownika jdbc niewiele mo�emy zrobi�
			e.printStackTrace();
		} finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                	//je�li wyst�pi�y b��dy to musimy spr�bowa� zamkn�� statement
                    stmt.close();
                }
            } catch (SQLException se2) {
            	//jeśli się nie udało - nic już nie możemy zrobić
            }
            try {
                if (conn != null) {
                	//próba zamknięcia połączenia, jeśli istnieje
                    conn.close();
                }
            } catch (SQLException se) {
            	//jeśli nie udało si� go zamknąć - komunikat
                se.printStackTrace();
            }
        }
    }
}
