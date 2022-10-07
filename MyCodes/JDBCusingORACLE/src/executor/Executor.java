package executor;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import oracle.jdbc.driver.OracleDriver;

public class Executor {

	private static Logger logger = Logger.getLogger(Executor.class);

	public static void main(String[] args) {

		Driver driver;
		Connection connection;
		Statement statement;
		ResultSet resultSet;

		try {

			Layout layout = new SimpleLayout();
			Appender appender = new ConsoleAppender(layout);
			logger.addAppender(appender);
			logger.setLevel(Level.INFO);

			// Load/Register driver.
			driver = new OracleDriver();
			DriverManager.registerDriver(driver);

			// Connect to database.
			String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
			String DB_USERNAME = "hr";
			String DB_PASSWORD = "hr";
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

			// Write query.
			statement = connection.createStatement();

			// Execute query.
			resultSet = statement.executeQuery("select * from all_users");

			logger.info(driver);
			logger.info(connection);
			logger.info(connection);
			logger.info(resultSet + "\n\n\n---------------------------------------------------\n\n\n");

			String text = "\n\n\nALL USER DETAILS IN ORACLE 11G EXPRESS EDITION DATABASE:\n\n\n"
					+ String.format("%s %-20s %s %-20s %s %-25s %s", "|", "--------------------", "|",
							"--------------------", "|", "-------------------------", "|")
					+ "\n"
					+ String.format("%s %-20s %s %-20s %s %-25s %s", "|", "Username", "|", "User Id", "|",
							"Account Creation Date", "|")
					+ "\n" + String.format("%s %-20s %s %-20s %s %-25s %s", "|", "--------------------", "|",
							"--------------------", "|", "-------------------------", "|")
					+ "\n";
			while (resultSet.next()) {
				text += String.format("%s %-20s %s %-20s %s %-25s %s", "|", resultSet.getString("USERNAME"), "|",
						resultSet.getString("USER_ID"), "|", resultSet.getDate("CREATED"), "|") + "\n";
			}
			text += String.format("%s %-20s %s %-20s %s %-25s %s", "|", "--------------------", "|",
					"--------------------", "|", "-------------------------", "|") + "\n";

			// Print result.
			logger.info(text + "\n\n\n" + "Execution successful.");

		} catch (Exception exception) {
			logger.error("Exception class : " + exception.getClass().getName());
			logger.error("Exception message : " + exception.getMessage());
		}

	}
}