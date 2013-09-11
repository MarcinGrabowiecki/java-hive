package dbutil;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseConnection;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.CommandLineParsingException;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import static com.javahive.javadb.jdbc.ConnectionData.*;

/**
 * 
 * @author Marcin Grabowiecki
 * 
 */

public class DBCreator {

	public void createTestDB() throws CommandLineParsingException, IOException,
			ClassNotFoundException, SQLException, LiquibaseException {
		Class.forName(DB_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		JdbcConnection jc = new JdbcConnection(conn);
		Database db = DatabaseFactory.getInstance()
				.findCorrectDatabaseImplementation(jc);
		String file = "src/main/resources/db.xml";
		Liquibase lb = new Liquibase(file, new FileSystemResourceAccessor(), db);
		lb.update(null);
	}
}
