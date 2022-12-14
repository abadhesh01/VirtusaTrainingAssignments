package service;

import java.sql.Driver;
import oracle.jdbc.driver.OracleDriver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ServiceImpl implements Service {

	private Driver driver;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public void setDatbaseConnection(Logger logger) {

		try {
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

			logger.info("DATE: " + new Date() + "\n\n");
			logger.info(driver);
			logger.info(connection);
			logger.info(connection);
			logger.info(resultSet + "\n");
		} catch (Exception exception) {
			logger.error("Exception class : " + exception.getClass().getName());
			logger.error("Exception message : " + exception.getMessage());
		}

		logger.info("Connection with database established successfully.\n\n");
	}

	public void getllUsersList(Logger logger) {
		try {
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
						resultSet.getString("USER_ID"), "|", resultSet.getDate("CREATED"), "|") + "\n"
						+ String.format("%s %-20s %s %-20s %s %-25s %s", "|", "--------------------", "|",
								"--------------------", "|", "-------------------------", "|")
						+ "\n";
			}

			// Print result.
			logger.info(text + "\n\n\n" + "Execution successful.");
		} catch (Exception exception) {
			logger.error("Exception class : " + exception.getClass().getName());
			logger.error("Exception message : " + exception.getMessage());
		}
	}

	public void releaseResourcesAndcloseConnection(Logger logger) {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException exception) {
			logger.error("Exception class : " + exception.getClass().getName());
			logger.error("Exception message : " + exception.getMessage());
		}

	}

}
