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
import static com.javahive.javadb.jdbc.ConnectionData.*;
/**
 *
 * @author mgr
 */
public class JDBCReader {


    public void read() {
        //1 - potrzebujemy deklaracji pól tutaj, by później można było próbować je zamknąć
        Connection conn = null;
        Statement stmt = null;
        try {
            //2 - ładowanie sterownika JDBC
            Class.forName(JDBC_DRIVER);
            //3 - łączenie z bazą
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //4 - wykonanie zapytania
            stmt = conn.createStatement();
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
        } catch (SQLException se) {
            //Obsługa błędów JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
			// W przypadku nieznalezienia sterownika jdbc niewiele mo�emy zrobi�
			e.printStackTrace();
		} finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                	//jeśli wystąpiły błędy to musimy spróbować zamknąć statement
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
            	//jeśli nie udało się go zamknąć - komunikat
                se.printStackTrace();
            }
        }
    }
}
