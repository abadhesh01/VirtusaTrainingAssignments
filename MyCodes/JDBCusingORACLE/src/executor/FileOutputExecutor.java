package executor;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import service.Service;
import service.ServiceImpl;

public class FileOutputExecutor {

	private static Logger logger = Logger.getLogger(FileOutputExecutor.class);

	public static void main(String[] args) {

		try {

			// Setting up logger.
			Layout layout = new SimpleLayout();
			Appender appender = new ConsoleAppender(layout);
			logger.addAppender(appender);
			logger.setLevel(Level.INFO);

			// Generating output file and displaying it's name and location on console.
			// Get output file at
			// "C:\Users\abadh\OneDrive\Documents\VirtusaTrainingAssignments\MyCodes\JDBCusingORACLE\OUTPUT".
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			DateFormat timeFormat = new SimpleDateFormat("hh-mm-ss");
			// Configure output file name here at variable "outputFileName".
			String outputFileName = "[DATE@" + dateFormat.format(date) + "]&&[TIME@" + timeFormat.format(date) + "]";
			// Configure output file location here at variable "outputFileLocation".
			String outputFileLocation = "C:\\Users\\abadh\\OneDrive\\Documents\\VirtusaTrainingAssignments\\MyCodes\\JDBCusingORACLE\\OUTPUT";
			String outputFilePath = outputFileLocation + "\\" + outputFileName;
			logger.info("Output file name : " + outputFileName);
			logger.info("Output file location : " + outputFileLocation);
			File file = new File(outputFilePath);
			file.createNewFile();

			// Resetting logger for output on auto generated file.
			logger = Logger.getRootLogger();
			appender = new FileAppender(layout, outputFilePath);
			logger.addAppender(appender);

			// Setting up services.
			Service service = new ServiceImpl();

			// Creating connection to database.
			service.setDatbaseConnection(logger);

			// Showing all users' details.
			service.getllUsersList(logger);

			// Closing connection to database and releasing resources.
			service.releaseResourcesAndcloseConnection(logger);

		} catch (Exception exception) {
			logger.error("Exception class : " + exception.getClass().getName());
			logger.error("Exception message : " + exception.getMessage());
		}

	}

}
