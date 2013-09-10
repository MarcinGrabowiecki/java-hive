package com.javahive.javadb.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import liquibase.exception.CommandLineParsingException;

/**
 * 
 * @author Marcin Grabowiecki
 *
 */

public class Start {
	public static void main(String[] args) throws CommandLineParsingException, IOException, ClassNotFoundException, SQLException {
		String arg="--driver org.h2.Driver --url jdbc:h2:test --username sa --password sa --changeLogFile db.xml migrate";
		arg="--driver org.h2.Driver --url jdbc:h2:file:C:/Java/HCM/HCM-Domena/src/main/resources/db/h2db1 --username sa generateChangeLog";
		liquibase.integration.commandline.Main.main(arg.split(" "));
		
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:test", "sa", "sa");
        PreparedStatement ps=conn.prepareStatement("select * from klienci");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        	System.out.println(rs.getString("imie"));
        }
        System.out.println("aaaaaaaaaa");
        conn.close();
		
	}
}
